package com.example.androidcustomcomponentsbyhuong

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class Pizza : View {
    private var mStrokeWidth = DEFAULT_STROKE_WIDTH
    private var mNumWedges = DEFAULT_NUM_WEDGES
    private var mColor = DEFAULT_COLOR
    private lateinit var mPaint:Paint
    constructor(context: Context?) : super(context){init(null)}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){init(attrs)}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){init(attrs)}

    private fun init(attrs :AttributeSet?){

        if(attrs!=null){
            val namespace = "http://schemas.android.com/apk/res-auto"
            mStrokeWidth = attrs.getAttributeIntValue(namespace, "stroke_width", DEFAULT_STROKE_WIDTH)
            mNumWedges = attrs.getAttributeIntValue(namespace, "num_wedges", DEFAULT_NUM_WEDGES)
            mColor = attrs.getAttributeIntValue(namespace, "color", DEFAULT_COLOR)
        }
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = mColor
        mPaint.strokeWidth = mStrokeWidth.toFloat()
        mPaint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        val width = width - paddingLeft - paddingRight
        val height = height - paddingTop - paddingBottom
        val diameter = Math.min(width,height) - mStrokeWidth
        val cx = width/2 + paddingLeft
        val cy = height/2 +paddingTop
        val radius = diameter/2
        canvas.drawCircle(cx.toFloat(),cy.toFloat(),radius.toFloat(),mPaint)
        drawPizzaCuts(canvas,cx.toFloat(),cy.toFloat(),radius.toFloat())
    }

    private fun drawPizzaCuts(canvas:Canvas,cx :Float,cy:Float,radius:Float){
        canvas.save()
        var degrees = 360f/mNumWedges
        for( i in 0..mNumWedges){
            canvas.rotate(degrees,cx,cy)
            canvas.drawLine(cx,cy,cx,cy - radius,mPaint)
        }
        canvas.restore()
    }

    companion object{
        const val DEFAULT_STROKE_WIDTH = 2
        const val DEFAULT_NUM_WEDGES = 5
        const val DEFAULT_COLOR = Color.YELLOW
    }
}