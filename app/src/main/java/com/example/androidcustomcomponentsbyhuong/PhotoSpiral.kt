package com.example.androidcustomcomponentsbyhuong

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup

class PhotoSpiral : ViewGroup {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureChildren(widthMeasureSpec, heightMeasureSpec)
        val first = getChildAt(0)
        val size = first.measuredWidth + first.measuredHeight
        val width = resolveSize(size, widthMeasureSpec)
        val height = resolveSize(size, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var first = getChildAt(0)
        var childWidth = first.measuredWidth
        var childHeight = first.measuredHeight
        var x = width / 2 - (childWidth - childHeight) / 2
        var y = height / 2 - (childWidth + childHeight) / 2
        for (i in 0 until childCount) {
            var child = getChildAt(i)
            x = adjustX(i, x, childWidth, childHeight)
            y = adjustY(i, y, childWidth, childHeight)
            child.layout(x, y, x + child.measuredWidth, y + child.measuredHeight)
        }
    }

    private fun adjustX(pos: Int, x: Int, childWidth: Int, childHeight: Int): Int {
        val delta = childWidth - childHeight
        when (pos) {
            1 -> return x + delta
            2 -> return x - childWidth
        }
        return x
    }

    private fun adjustY(pos: Int, y: Int, childWidth: Int, childHeight: Int): Int {
        val delta = childWidth - childHeight
        when (pos) {
            1 -> return y + childHeight
            2 -> return y + delta
            3 -> return y - childWidth
        }
        return y
    }

}