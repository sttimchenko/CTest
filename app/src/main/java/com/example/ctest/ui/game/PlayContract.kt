package com.example.ctest.ui.game

import com.example.ctest.data.GameUnit

/**
 * Created by ss on 17.12.16.
 */
interface PlayContract {
    interface View {
        fun onDataGenerated(list : List<GameUnit>)
        fun onTurnMade(index: Int)
    }

    interface Presenter {
        fun onViewAttached()
        fun onViewDetached()
        fun requestTurn()
    }
}