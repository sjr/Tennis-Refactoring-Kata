package com.dojo.refactor

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import kotlin.math.max

@RunWith(Parameterized::class)
class TennisTest(
    private val player1Score: Int,
    private val player2Score: Int,
    private val expectedScore: String
) {

    companion object {
        @Suppress("unused")
        val allScores
            @JvmStatic
            @Parameters
            get() =
                listOf(
                    arrayOf(0, 0, "Love-All"),
                    arrayOf(1, 1, "Fifteen-All"),
                    arrayOf(2, 2, "Thirty-All"),
                    arrayOf(3, 3, "Deuce"),
                    arrayOf(4, 4, "Deuce"),
                    arrayOf(1, 0, "Fifteen-Love"),
                    arrayOf(0, 1, "Love-Fifteen"),
                    arrayOf(2, 0, "Thirty-Love"),
                    arrayOf(0, 2, "Love-Thirty"),
                    arrayOf(3, 0, "Forty-Love"),
                    arrayOf(0, 3, "Love-Forty"),
                    arrayOf(4, 0, "Win for player1"),
                    arrayOf(0, 4, "Win for player2"),
                    arrayOf(2, 1, "Thirty-Fifteen"),
                    arrayOf(1, 2, "Fifteen-Thirty"),
                    arrayOf(3, 1, "Forty-Fifteen"),
                    arrayOf(1, 3, "Fifteen-Forty"),
                    arrayOf(4, 1, "Win for player1"),
                    arrayOf(1, 4, "Win for player2"),
                    arrayOf(3, 2, "Forty-Thirty"),
                    arrayOf(2, 3, "Thirty-Forty"),
                    arrayOf(4, 2, "Win for player1"),
                    arrayOf(2, 4, "Win for player2"),
                    arrayOf(4, 3, "Advantage player1"),
                    arrayOf(3, 4, "Advantage player2"),
                    arrayOf(5, 4, "Advantage player1"),
                    arrayOf(4, 5, "Advantage player2"),
                    arrayOf(15, 14, "Advantage player1"),
                    arrayOf(14, 15, "Advantage player2"),
                    arrayOf(6, 4, "Win for player1"),
                    arrayOf(4, 6, "Win for player2"),
                    arrayOf(16, 14, "Win for player1"),
                    arrayOf(14, 16, "Win for player2")
                )
    }

    private fun checkAllScores(game: TennisGame) {
        val highestScore = max(this.player1Score, this.player2Score)
        for (i in 0 until highestScore) {
            if (i < this.player1Score)
                game.wonPoint("player1")
            if (i < this.player2Score)
                game.wonPoint("player2")
        }
        assertEquals(this.expectedScore, game.getScore())
    }

    @Test
    fun checkAllScoresTennisGame1() {
        val game = TennisGame1("player1", "player2")
        checkAllScores(game)
    }

    @Test
    fun checkAllScoresTennisGame2() {
        val game = TennisGame2("player1", "player2")
        checkAllScores(game)
    }

    @Test
    fun checkAllScoresTennisGame3() {
        val game = TennisGame3("player1", "player2")
        checkAllScores(game)
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkPlayerNamesAreDifferent1() {
        TennisGame1("player1", "player1")
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkPlayerNamesAreDifferent2() {
        TennisGame2("player1", "player1")
    }
}
