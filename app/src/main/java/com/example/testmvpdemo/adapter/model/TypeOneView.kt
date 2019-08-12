package com.example.testmvpdemo.adapter.model

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.testmvpdemo.R
import com.example.testmvpdemo.adapter.TestSingleTypeModel
import kotlinx.android.synthetic.main.type1_item_layout.view.*

class TypeOneView : LinearLayout {
    @JvmOverloads
    constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.type1_item_layout, this, false)
        btn_toast?.setOnClickListener {
            Toast.makeText(context, "click button", Toast.LENGTH_SHORT).show()
            Log.d("Type1", "clicked first type button")
        }
    }
    var model: TestSingleTypeModel? = null
        set(value) {
            field = value
            updateUI()
        }
    private fun updateUI() {
        item_type1_text_title?.text = model?.title
        btn_toast?.text = model?.content
    }
}