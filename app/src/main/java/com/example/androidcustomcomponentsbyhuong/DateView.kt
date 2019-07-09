package com.example.androidcustomcomponentsbyhuong

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


class DateView: TextView {
    constructor(context: Context?) : super(context){
        setDate()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        setDate()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        setDate()
    }

    private fun setDate(){
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val today = dateFormat.format(Calendar.getInstance().time)
        text = today
    }

}