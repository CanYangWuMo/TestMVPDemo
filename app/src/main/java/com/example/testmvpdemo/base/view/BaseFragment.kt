package com.example.testmvpdemo.base.view

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.testmvpdemo.base.mvp.BaseContract
import com.example.testmvpdemo.base.mvp.BasePresenter

abstract class BaseFragment : Fragment(), BaseContract.View {
    protected var presenter: BasePresenter<BaseFragment>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        presenter?.attachView(this)
    }

    override fun onDestroy() {
        presenter?.detachView()
        super.onDestroy()
    }

    abstract fun createPresenter(): BasePresenter<BaseFragment>

    override fun showLoading() {
//        if (isAttachActivity() && activity is BasePresenterActivity) {
//            (activity as BasePresenterActivity).showLoading()
//        }
    }

    override fun hideLoading() {
//        if (isAttachActivity() && activity is BasePresenterActivity) {
//            (activity as BasePresenterActivity).hideLoading()
//        }
    }

    override fun close() {
    }

    protected fun isAttachActivity(): Boolean {
        return activity != null
    }
}