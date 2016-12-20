package com.example.ctest.ui.game

import android.os.Build
import com.example.ctest.BuildConfig
import com.example.ctest.data.GameUnit
import com.example.ctest.data.GameUnitFactory
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import org.junit.Before
import org.junit.Test
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.robolectric.Robolectric
import java.util.*
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.os.Build.VERSION_CODES

class PlayPresenterTest {

    lateinit var view : PlayContract.View
    lateinit var presenter : PlayPresenter

    @Before
    fun setup() {
        view = Mockito.mock(PlayContract.View::class.java)
        presenter = PlayPresenter(view)
    }
    @Test
    fun testRequestTurn() {
        presenter.items = ArrayList(presenter.fieldSize)

        val unit = GameUnitFactory().createQueen()

        var list = ArrayList<GameUnit>()
        for (i in 1..28) {
            list.add(unit)
        }

        presenter.items = list

        presenter.requestTurn()

        verify(view).onTurnMade(ArgumentMatchers.anyInt())
    }

    @Test
    fun testGenerateArmy() {
        presenter.generateArmy().subscribe { list ->
            var q = 0
            var w = 0
            var d = 0
            var e = 0

            for (item in list){
                when(item.sign){
                    "Q" -> q++
                    "W" -> w++
                    "D" -> d++
                    "E" -> e++
                }
            }

            assertTrue(q == 1)
            assertTrue(w == 5)
            assertTrue(d == 8)
            assertTrue(e == 14)
            assertTrue(list.size == 28)
        }
    }
}