package com.tictactoe.model

enum class Player {
    X, O, NONE
}

data class GameState(
    val board: Array<Array<Player>> = Array(3) { Array(3) { Player.NONE } },
    val currentPlayer: Player = Player.X,
    val winner: Player = Player.NONE,
    val isGameOver: Boolean = false
) {
    fun isBoardFull(): Boolean = board.all { row -> row.all { it != Player.NONE } }
    
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as GameState
        return board.contentDeepEquals(other.board) &&
               currentPlayer == other.currentPlayer &&
               winner == other.winner &&
               isGameOver == other.isGameOver
    }

    override fun hashCode(): Int {
        var result = board.contentDeepHashCode()
        result = 31 * result + currentPlayer.hashCode()
        result = 31 * result + winner.hashCode()
        result = 31 * result + isGameOver.hashCode()
        return result
    }
}