package com.example.testmvpdemo.adapter.model

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.example.testmvpdemo.adapter.TestSingleTypeModel

class TestEntity : MultiItemEntity {

    var type = TYPE_NULL
    var model: TestSingleTypeModel? = null
    override fun getItemType(): Int {
        return type
    }

    fun setEntityType1(model: TestSingleTypeModel): TestEntity {
        this.type = TYPE_TEST_EDIT
        this.model = model
        return this
    }

    fun setEntityType2(model: TestSingleTypeModel): TestEntity {
        this.type = TYPE_TEST_CHECKBOX
        this.model = model
        return this
    }

    companion object {
        const val TYPE_NULL = 0
        const val TYPE_TEST_EDIT = 1
        const val TYPE_TEST_CHECKBOX = 2
    }
}