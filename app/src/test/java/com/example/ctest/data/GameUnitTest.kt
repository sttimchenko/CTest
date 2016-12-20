package com.example.ctest.data

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

class GameUnitTest {
    @Test
    fun gameUnitPrimaryTest() {
        var testUnit = GameUnit("Q", 100, 8)

        testUnit.hit()

        assertTrue(testUnit.life == testUnit.currentLife + testUnit.damage)
        assertTrue(testUnit.sign == "Q")

        testUnit.currentLife = testUnit.damage
        assertFalse(testUnit.hit())

        testUnit = GameUnit("W", 75, 10)

        testUnit.hit()

        assertTrue(testUnit.life == testUnit.currentLife + testUnit.damage)
        assertTrue(testUnit.sign == "W")

        testUnit.currentLife = testUnit.damage
        assertFalse(testUnit.hit())

        testUnit = GameUnit("D", 50, 12)

        testUnit.hit()

        assertTrue(testUnit.life == testUnit.currentLife + testUnit.damage)
        assertTrue(testUnit.sign == "D")

        testUnit.currentLife = testUnit.damage
        assertFalse(testUnit.hit())

        testUnit = GameUnit("E", 0, 0)

        testUnit.hit()

        assertTrue(testUnit.life == testUnit.currentLife + testUnit.damage)
        assertTrue(testUnit.sign == "E")

        testUnit.currentLife = testUnit.damage
        assertFalse(testUnit.hit())
    }

}