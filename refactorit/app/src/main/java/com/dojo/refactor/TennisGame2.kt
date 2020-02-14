package com.dojo.refactor

class TennisGame2(player1Name: String, player2Name: String) : TennisGame {
    private var playerOneScore: Int = 0
    private var playerTwoScore: Int = 0

    init {
        require(player1Name != player2Name)
        require(player1Name.isNotEmpty() && player2Name.isNotEmpty())
    }

    override fun getScore(): String {
        var score = ""

        if (playerOneScore == playerTwoScore) {
            score = if (playerOneScore >= 3) {
                "Deuce"
            } else {
                getScoreText(playerOneScore) + "-All"
            }
        } else if (playerOneScore < 4 && playerTwoScore < 4) {
            score = "${getScoreText(playerOneScore)}-${getScoreText(playerTwoScore)}"
        } else {
            if (playerTwoScore in 3 until playerOneScore) {
                score = "Advantage player1"
            } else if (playerOneScore in 3 until playerTwoScore) {
                score = "Advantage player2"
            }

            if (playerOneScore >= 4 && playerTwoScore >= 0 && playerOneScore - playerTwoScore >= 2) {
                score = "Win for player1"
            }
            if (playerTwoScore >= 4 && playerOneScore >= 0 && playerTwoScore - playerOneScore >= 2) {
                score = "Win for player2"
            }
        }
        return score
    }

    private fun getScoreText(score: Int): String {
        return when (score) {
            0 -> "Love"
            1 -> "Fifteen"
            2 -> "Thirty"
            3 -> "Forty"
            else -> ""
        }
    }

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            playerOneScore++
        else
            playerTwoScore++
    }
}