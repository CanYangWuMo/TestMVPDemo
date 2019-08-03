package com.example.testmvpdemo.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.testmvpdemo.R

class SingleTypeAdapter(dataLists: ArrayList<TestSingleTypeModel>) :
    BaseQuickAdapter<TestSingleTypeModel, BaseViewHolder>(R.layout.single_type_layout,dataLists) {

    override fun convert(helper: BaseViewHolder?, item: TestSingleTypeModel?) {
        helper?.setText(R.id.test_single_type_title, item?.title ?: "no title")
        helper?.setText(R.id.test_single_type_content, item?.title ?: "no content")
    }
}

data class TestSingleTypeModel(var title: String = "nothing", var content: String = "nothing here")