package com.dojo

import com.dojo.poker.Card
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
        playerAValues: List<Card>,
        playerBValues: List<Card>
    ) {
        val pokerHands = PokerHands()
        val actualResult = pokerHands.getWinner(playerAValues, playerBValues)

        assertEquals(message, expected, actualResult)
    }

    fun getInput() = arrayOf(

        arrayOf(
            "High card with player A",
            "Player A Wins",
            listOf(Card(2, 1), Card(3, 1), Card(4, 1), Card(5, 2), Card(13, 1)),
            listOf(Card(7, 1), Card(8, 1), Card(9, 1), Card(10, 2), Card(12, 1))
        ),
        arrayOf(
            "High card with player B",
            "Player B Wins",
            listOf(Card(2, 1), Card(3, 1), Card(4, 1), Card(5, 2), Card(10, 1)),
            listOf(Card(7, 1), Card(8, 1), Card(9, 1), Card(10, 2), Card(12, 1))
        ),
        arrayOf(
            "Both players have same value cards",
            "Tie",
            listOf(Card(2, 1), Card(3, 1), Card(4, 1), Card(5, 2), Card(10, 1)),
            listOf(Card(2, 2), Card(3, 2), Card(4, 2), Card(5, 1), Card(10, 2))
        ),
        arrayOf(
            "Player A have Pair and Player B doesn't",
            "Player A Wins",
            listOf(Card(2, 1), Card(2, 3), Card(4, 1), Card(5, 2), Card(10, 1)),
            listOf(Card(2, 2), Card(3, 2), Card(4, 2), Card(5, 1), Card(10, 2))
        ),
        arrayOf(
            "Player B have Pair and Player A doesn't",
            "Player B Wins",
            listOf(Card(2, 1), Card(3, 3), Card(4, 1), Card(5, 2), Card(10, 1)),
            listOf(Card(2, 2), Card(2, 3), Card(4, 2), Card(5, 1), Card(10, 2))
        )
    )
}