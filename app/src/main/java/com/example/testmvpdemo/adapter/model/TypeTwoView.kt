package com.example.testmvpdemo.adapter.model

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.testmvpdemo.R
import com.example.testmvpdemo.adapter.TestSingleTypeModel
import kotlinx.android.synthetic.main.type2_item_layout.view.*

class TypeTwoView : LinearLayout {
    @JvmOverloads
    constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
    ) : super(context, attrs, defStyleAttr) {
    }

    var model: TestSingleTypeModel? = null
        set(value) {
            field = value
            updateUI()
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.type2_item_layout, this, false)
    }

    private fun updateUI() {
        item_type2_text_title?.text = model?.title
        item_type2_checkbox?.text = model?.title
    }
}