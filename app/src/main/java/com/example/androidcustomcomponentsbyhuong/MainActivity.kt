package com.example.androidcustomcomponentsbyhuong

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mWidth: LengthPicker? = null
    private var mHeight: LengthPicker? = null
    private var mArea: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mWidth = findViewById(R.id.width)
        mHeight = findViewById(R.id.height)
        mArea = findViewById(R.id.area)
        computer.setOnClickListener{
            updateArea()
        }
    }

    private fun updateArea(){
        var area = mWidth?.getNumInches()!! * mHeight?.getNumInches()!!
        mArea?.text = getString(R.string.area_format,area)
    }
}
