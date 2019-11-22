package com.example.testmvpdemo.base.view

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.testmvpdemo.base.mvp.BaseContract
import com.example.testmvpdemo.base.mvp.BasePresenter

abstract class BaseFragment : Fragment(), BaseContract.View {
    protected var presenter: BasePresenter<BaseFragment>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        presenter = BasePresenter()
        presenter?.attachView(this)
    }

    override fun onDestroy() {
        presenter?.detachView()
        super.onDestroy()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun close() {
    }

    protected fun isAttachActivity(): Boolean {
        return activity != null
    }
}