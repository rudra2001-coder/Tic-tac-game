package com.tictactoe.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.tictactoe.model.Player

class GameCell @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    
    private val textView: TextView = TextView(context).apply {
        textSize = 40f
        textAlignment = TEXT_ALIGNMENT_CENTER
    }

    init {
        addView(textView)
    }

    fun setPlayer(player: Player) {
        textView.text = when (player) {
            Player.X -> "X"
            Player.O -> "O"
            Player.NONE -> ""
        }
    }
}