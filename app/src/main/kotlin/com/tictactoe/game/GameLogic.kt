package com.tictactoe.game

import com.tictactoe.model.GameState
import com.tictactoe.model.Player

class GameLogic {
    fun makeMove(state: GameState, row: Int, col: Int): GameState {
        if (state.isGameOver || state.board[row][col] != Player.NONE) {
            return state
        }

        val newBoard = state.board.map { it.clone() }.toTypedArray()
        newBoard[row][col] = state.currentPlayer

        val winner = checkWinner(newBoard)
        val isGameOver = winner != Player.NONE || isBoardFull(newBoard)

        return GameState(
            board = newBoard,
            currentPlayer = if (state.currentPlayer == Player.X) Player.O else Player.X,
            winner = winner,
            isGameOver = isGameOver
        )
    }

    private fun checkWinner(board: Array<Array<Player>>): Player {
        // Check rows
        for (row in board) {
            if (row[0] != Player.NONE && row[0] == row[1] && row[1] == row[2]) {
                return row[0]
            }
        }

        // Check columns
        for (col in 0..2) {
            if (board[0][col] != Player.NONE &&
                board[0][col] == board[1][col] &&
                board[1][col] == board[2][col]
            ) {
                return board[0][col]
            }
        }

        // Check diagonals
        if (board[0][0] != Player.NONE &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]
        ) {
            return board[0][0]
        }

        if (board[0][2] != Player.NONE &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]
        ) {
            return board[0][2]
        }

        return Player.NONE
    }

    private fun isBoardFull(board: Array<Array<Player>>): Boolean =
        board.all { row -> row.all { it != Player.NONE } }
}