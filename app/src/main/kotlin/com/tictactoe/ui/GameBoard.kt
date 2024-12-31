package com.tictactoe.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout
import com.tictactoe.model.GameState
import com.tictactoe.model.Player

class GameBoard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : GridLayout(context, attrs, defStyleAttr) {

    private val cells = Array(3) { row ->
        Array(3) { col ->
            GameCell(context).apply {
                layoutParams = LayoutParams().apply {
                    width = 0
                    height = 0
                    rowSpec = spec(row, 1f)
                    columnSpec = spec(col, 1f)
                }
            }
        }
    }

    init {
        rowCount = 3
        columnCount = 3
        cells.flatten().forEach(::addView)
    }

    fun updateBoard(gameState: GameState) {
        for (row in 0..2) {
            for (col in 0..2) {
                cells[row][col].setPlayer(gameState.board[row][col])
            }
        }
    }
}