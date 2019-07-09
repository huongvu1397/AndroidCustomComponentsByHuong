package com.example.androidcustomcomponentsbyhuong

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class LengthPicker : LinearLayout, View.OnClickListener {
    private var mNumInches = 0
    private var mMinusButton: View? = null
    private var mPlusButton: View? = null
    private var mTextView: TextView? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    companion object {
        const val SUPER_STATE = "superState"
        const val NUM_INCHES = "superState"
    }

    private fun init() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.length_picker, this)
        mPlusButton = findViewById(R.id.plus_button)
        mMinusButton = findViewById(R.id.minus_button)
        mTextView = findViewById(R.id.text)
        updateControls()
        mPlusButton?.setOnClickListener(this)
        mMinusButton?.setOnClickListener(this)
    }

    private fun updateControls() {
        var feet = mNumInches / 12
        var inches = mNumInches % 12
        var text = String.format("%d' %d\"", feet, inches)
        if (feet == 0) {
            text = String.format("%d\"", inches)
        } else {
            if (inches == 0) {
                text = String.format("%d'", feet)
            }
        }
        mTextView?.text = text
        mMinusButton?.isEnabled = mNumInches > 0
    }

    fun getNumInches(): Int {
        return mNumInches
    }

    override fun onSaveInstanceState(): Parcelable? {
        var bundle = Bundle()
        bundle.putParcelable(SUPER_STATE, super.onSaveInstanceState())
        bundle.putInt(NUM_INCHES, mNumInches)
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            val bundle = state
            mNumInches = bundle.getInt(NUM_INCHES)
            super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE))
        } else {
            super.onRestoreInstanceState(state)
        }
        updateControls()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.plus_button -> {
                mNumInches++
                updateControls()
            }
            R.id.minus_button -> {
                if (mNumInches > 0) {
                    mNumInches--
                    updateControls()
                }
            }
        }
    }

}