package com.example.ctest.data

/**
 * Created by ss on 18.12.16.
 */
class GameUnitFactory {
    fun createQueen() : GameUnit {
        return GameUnit("Q", 100, 8)
    }

    fun createWorker() : GameUnit {
        return GameUnit("W", 75, 10)
    }

    fun createDrone() : GameUnit {
        return GameUnit("D", 50, 12)
    }

    fun createEmpty() : GameUnit {
        return GameUnit("E", 0, 0)
    }
}