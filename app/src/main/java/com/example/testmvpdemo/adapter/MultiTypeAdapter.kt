package com.example.testmvpdemo.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.testmvpdemo.R
import com.example.testmvpdemo.adapter.model.TestEntity
import com.example.testmvpdemo.adapter.model.TypeOneView
import com.example.testmvpdemo.adapter.model.TypeTwoView

class MultiTypeAdapter(listData: List<TestEntity>) : BaseMultiItemQuickAdapter<TestEntity, BaseViewHolder>(listData) {

    init {
        addItemType(TestEntity.TYPE_TEST_EDIT, R.layout.recycler_type1_layout)
        addItemType(TestEntity.TYPE_TEST_CHECKBOX, R.layout.recycler_type2_layout)
    }

    override fun convert(helper: BaseViewHolder?, item: TestEntity?) {
        when (helper?.itemViewType) {
            TestEntity.TYPE_TEST_EDIT -> {
                helper.getView<TypeOneView>(R.id.type_one_view_item).model = item?.model
            }
            TestEntity.TYPE_TEST_CHECKBOX -> {
                helper.getView<TypeTwoView>(R.id.type_two_view_item).model = item?.model
            }
            else -> {

            }
        }
    }
}