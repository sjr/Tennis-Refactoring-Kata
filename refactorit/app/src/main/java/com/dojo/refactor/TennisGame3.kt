package com.dojo.refactor

class TennisGame3(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player1Score: Int = 0
    private var player2Score: Int = 0


    override fun getScore(): String {
        return when {
            isNonDeuceScore() -> {

                if (player1Score == player2Score) {
                    "${getScoreText(player1Score)}-All"
                } else {
                    "${getScoreText(player1Score)}-${getScoreText(player2Score)}"
                }

            }
            player1Score == player2Score -> {
                "Deuce"
            }
            else -> {
                val winningPlayer = getWinningPlayerName()

                if ((player1Score - player2Score) * (player1Score - player2Score) == 1) {
                    "Advantage $winningPlayer"
                } else {
                    "Win for $winningPlayer"
                }
            }
        }
    }

    override fun wonPoint(playerName: String) {
        if (playerName == player1Name)
            player1Score++
        else
            player2Score++

    }

    private fun getWinningPlayerName(): String {

        return if (player1Score > player2Score) {
            player1Name
        } else {
            player2Name
        }
    }

    private fun getScoreText(score: Int) = SCORE_TEXT[score]

    private fun isNonDeuceScore() =
        player1Score < SCORE_FORTY && player2Score < SCORE_FORTY && player1Score + player2Score != 6

    companion object {
        private val SCORE_TEXT = arrayOf("Love", "Fifteen", "Thirty", "Forty")
        private const val SCORE_FORTY = 4
    }
}
