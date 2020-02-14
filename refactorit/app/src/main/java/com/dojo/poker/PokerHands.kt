package com.dojo.poker


class Card(val value: Int, val suit: Int) : Comparable<Card> {
    override fun compareTo(other: Card): Int {
        return value.compareTo(other.value)
    }
}


class PokerHands {

    fun getWinner(playerAValues: List<Card>, playerBValues: List<Card>): String {
        val playerASortedValues = playerAValues.sortedDescending()
        val playerBSortedValues = playerBValues.sortedDescending()

        return checkPair(playerASortedValues, playerBSortedValues)
            ?: checkValue(playerASortedValues, playerBSortedValues) //checkTriple()?:checkValue()
    }

    private fun checkPair(playerAValues: List<Card>, playerBValues: List<Card>): String? {

        val pairCountA = getPair(playerAValues)
        val pairCountB = getPair(playerBValues)

        if (pairCountA == 2) {
            return "Player A Wins"
        } else if (pairCountB == 2) {
            return "Player B Wins"
        }
        return null
    }

    private fun checkValue(playerAValues: List<Card>, playerBValues: List<Card>): String {
        var i = 0
        while (i < 5) {
            if (playerAValues[i].value < playerBValues[i].value) {
                return "Player B Wins"
            } else if (playerAValues[i].value > playerBValues[i].value) {
                return "Player A Wins"
            }
            i++
        }
        return "Tie"
    }

    fun getPair(cards: List<Card>): Int {
        var i = 0
        while (i < 5) {
            cards.count { it.value == cards[i].value }
            i++
        }
        return 0
    }
}