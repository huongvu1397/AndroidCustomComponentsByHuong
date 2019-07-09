package com.example.androidcustomcomponentsbyhuong

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout

class SidewaysLayout :LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredHeight,measuredWidth)
    }

    override fun dispatchDraw(canvas: Canvas) {
        canvas.save()
        canvas.translate(0f, height.toFloat())
        canvas.rotate(-90f,0f,0f)
        super.dispatchDraw(canvas)
        canvas.restore()
    }

}