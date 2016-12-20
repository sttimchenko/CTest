package com.example.ctest.ui.game

import android.util.Log
import com.example.ctest.data.GameUnit
import com.example.ctest.data.GameUnitFactory
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by ss on 17.12.16.
 */
class PlayPresenter(val view :PlayContract.View) : PlayContract.Presenter {
    val fieldSize = 28

    val qMax = 1
    val wMax = 5
    val dMax = 8
    val eMax = 14

    val minRand = 1
    val maxRand = 4

    lateinit var items : ArrayList<GameUnit>

    override fun onViewAttached() {
        items = ArrayList(fieldSize)

        createGame()
    }

    override fun onViewDetached() {

    }

    override fun requestTurn() {
        val n = ThreadLocalRandom.current().nextInt(0, fieldSize)

        val item = items[n]

        if (item.life > 0) {
            if (!items[n].hit() && item.sign == "Q") {
                createGame()
                return
            }

            view.onTurnMade(n)
        } else {
            requestTurn()
        }
    }

    fun createGame(){
        generateArmy()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<List<GameUnit>>() {
                    override fun onError(e: Throwable) {
                        Log.e(this@PlayPresenter.javaClass.simpleName, e.message)
                    }

                    override fun onCompleted() {

                    }

                    override fun onNext(t: List<GameUnit>) {
                        view.onDataGenerated(t)
                    }

                })
    }

    fun generateArmy() : Observable<List<GameUnit>> {
        return Observable.create { t ->
            var q = 0
            var w = 0
            var d = 0
            var e = 0

            items = ArrayList<GameUnit>()

            var n = 0

            val factory = GameUnitFactory()

            while ((q + w + d + e) < fieldSize){
                n = ThreadLocalRandom.current().nextInt(minRand, maxRand + 1)

                when (n) {
                    1 -> if (q < qMax){
                        items.add(factory.createQueen())
                        q++
                    }

                    2 -> if (w < wMax){
                        items.add(factory.createWorker())
                        w++
                    }

                    3 -> if (d < dMax){
                        items.add(factory.createDrone())
                        d++
                    }

                    4 -> if (e < eMax){
                        items.add(factory.createEmpty())
                        e++
                    }
                }
            }

            t.onNext(items)
            t.onCompleted()
        }
    }
}