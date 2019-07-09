package com.example.androidcustomcomponentsbyhuong

import android.content.Context
import android.util.AttributeSet
import android.view.View

class SquareView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var size = Math.min(measuredWidth,measuredHeight)
        setMeasuredDimension(size,size)
    }
}