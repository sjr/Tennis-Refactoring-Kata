package com.dojo

import com.dojo.poker.PokerHands
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class PokerHandsTest {

    @Test
    @Parameters(method = "getInput")
    @TestCaseName("test {0} with A={2} and B={3} should return {1}")
    fun `test my input`(
        message: String,
        expected: String,
        playerAValues: List<Int>,
        playerBValues: List<Int>
    ) {
        val pokerHands = PokerHands()
        val actualResult = pokerHands.getWinner(playerAValues, playerBValues)

        assertEquals(message, expected, actualResult)
    }

    fun getInput() = arrayOf(

        arrayOf(
            "High card with player A",
            "Player A Wins",
            listOf(2, 3, 4, 5, 13),
            listOf(7, 8, 9, 10, 12)
        )
    )
}