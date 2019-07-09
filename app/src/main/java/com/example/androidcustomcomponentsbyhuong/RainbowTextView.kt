package com.example.androidcustomcomponentsbyhuong

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Shader
import android.util.AttributeSet
import android.widget.TextView

class RainbowTextView : TextView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        var rainbow = getRainbowColors()
        var shader = LinearGradient(0f,0f,0f,w.toFloat(),rainbow,null, Shader.TileMode.MIRROR)
        var matrix = Matrix()
        matrix.setRotate(90f)
        shader.setLocalMatrix(matrix)
        paint.shader = shader
    }

    private fun getRainbowColors(): IntArray {
        return intArrayOf(
            resources.getColor(R.color.rainbow_red),
            resources.getColor(R.color.rainbow_blue),
            resources.getColor(R.color.rainbow_green),
            resources.getColor(R.color.rainbow_yellow),
            resources.getColor(R.color.rainbow_violet)
        )
    }

}