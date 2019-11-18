package com.dojo.refactor

interface TennisGame {
    fun getScore(): String
    fun wonPoint(playerName: String)
}