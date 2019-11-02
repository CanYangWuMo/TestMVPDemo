package com.example.testmvpdemo.base.view

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.testmvpdemo.base.mvp.BaseContract
import com.example.testmvpdemo.base.mvp.BasePresenter

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {
    protected var presenter: BasePresenter<BaseActivity>? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        presenter = createPresenter()
        presenter?.attachView(this)
    }

    override fun onDestroy() {
        presenter?.detachView()
        super.onDestroy()
    }
    abstract fun createPresenter():BasePresenter<BaseActivity>

    override fun getContext(): Context? {
        return this
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun close() {
    }
}