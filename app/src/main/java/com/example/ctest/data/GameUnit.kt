package com.example.ctest.data

class GameUnit(var sign : String, val life : Int, var damage: Int) {

    var currentLife : Int = life

    /**
     * @return true if unit stays alive after hit, false otherwise
     */
    fun hit() : Boolean {
        currentLife -= damage

        if (currentLife < 0) currentLife = 0

        return currentLife > 0
    }
}