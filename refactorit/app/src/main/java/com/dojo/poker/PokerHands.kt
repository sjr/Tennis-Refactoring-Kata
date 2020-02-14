package com.dojo.poker


class Card(val value: Int, val suit: Int)


class PokerHands {

    fun getWinner(playerAValues: List<Card>, playerBValues: List<Card>) : String {
        val playerASortedValues = playerAValues.sortedByDescending { a, b ->
            a.value - b.value
        }


        return checkValue(playerAValues, playerBValues) //checkTriple()?:checkPair()?:checkValue()
    }

    fun checkValue(playerAValues: List<Card>, playerBValues: List<Card>): String {
        return "Player A Wins"
    }
}