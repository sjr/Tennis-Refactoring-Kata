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

        val aHasPair = hasPair(playerAValues)
        val bHasPair = hasPair(playerBValues)

        return when {
            aHasPair && bHasPair -> {
                if (getPairValue(playerAValues) > getPairValue(playerBValues)) {
                    "Player A Wins"
                } else "Player B Wins"
            }
            aHasPair -> {
                "Player A Wins"
            }
            bHasPair -> {
                "Player B Wins"
            }
            else -> null
        }
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

    fun getPairValue(cards: List<Card>): Int {
        for(card in cards) {
            if(countDuplicates(cards, card.value) == 2) {
                return card.value
            }
        }
        return 0
    }

    fun hasPair(cards: List<Card>): Boolean {
        for(card in cards) {
            if(countDuplicates(cards, card.value) == 2) {
                return true
            }
        }
        return false
    }

    fun countDuplicates(cards: List<Card>, value: Int): Int {
        return cards.count { it.value == value }
    }
}