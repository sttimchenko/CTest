package com.example.ctest.data

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Created by ss on 20.12.16.
 */
class GameUnitFactoryTest {

    val factory = GameUnitFactory()

    @Test
    fun createQueen() {
        val testUnit = factory.createQueen()

        Assert.assertTrue(testUnit.sign == "Q")
    }

    @Test
    fun createWorker() {
        val testUnit = factory.createWorker()

        Assert.assertTrue(testUnit.sign == "W")
    }

    @Test
    fun createDrone() {
        val testUnit = factory.createDrone()

        Assert.assertTrue(testUnit.sign == "D")
    }

    @Test
    fun createEmpty() {
        val testUnit = factory.createEmpty()

        Assert.assertTrue(testUnit.sign == "E")
    }

}