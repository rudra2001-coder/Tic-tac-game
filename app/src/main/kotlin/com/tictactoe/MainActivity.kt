package com.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tictactoe.game.GameLogic
import com.tictactoe.model.GameState
import com.tictactoe.model.Player
import com.tictactoe.ui.GameBoard

class MainActivity : AppCompatActivity() {
    private lateinit var gameBoard: GameBoard
    private lateinit var statusText: TextView
    private lateinit var resetButton: Button
    private val gameLogic = GameLogic()
    private var gameState = GameState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameBoard = findViewById(R.id.gameBoard)
        statusText = findViewById(R.id.statusText)
        resetButton = findViewById(R.id.resetButton)

        resetButton.setOnClickListener { resetGame() }
        updateUI()
    }

    private fun updateUI() {
        gameBoard.updateBoard(gameState)
        statusText.text = when {
            gameState.winner != Player.NONE -> "Player ${gameState.winner} wins!"
            gameState.isGameOver -> "Game Over - Draw!"
            else -> "Player ${gameState.currentPlayer}'s turn"
        }
    }

    private fun resetGame() {
        gameState = GameState()
        updateUI()
    }
}