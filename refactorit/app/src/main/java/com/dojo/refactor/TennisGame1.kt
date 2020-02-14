package com.dojo.refactor

class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var score1: Int = 0
    private var score2: Int = 0

    init {
        require(player1Name != player2Name)
        require(player1Name.isNotEmpty() && player2Name.isNotEmpty())
    }

    override fun wonPoint(playerName: String) {
        if (playerName == player1Name)
            score1 += 1
        else
            score2 += 1
    }

    override fun getScore(): String {
        return if (score1 == score2) {
            if (score1 >= 3) {
                "Deuce"
            } else {
                "${getScoreText(score1)}-All"
            }
        } else if (score1 >= 4 || score2 >= 4) {
            val minusResult = score1 - score2
            when {
                minusResult == 1 -> "Advantage $player1Name"
                minusResult == -1 -> "Advantage $player2Name"
                minusResult >= 2 -> "Win for $player1Name"
                else -> "Win for $player2Name"
            }
        } else {
            "${getScoreText(score1)}-${getScoreText(score2)}"
        }
    }

    private fun getScoreText(score: Int) = when (score) {
        0 -> "Love"
        1 -> "Fifteen"
        2 -> "Thirty"
        3 -> "Forty"
        else -> throw IllegalArgumentException("Unable to handle $score")
    }
}
