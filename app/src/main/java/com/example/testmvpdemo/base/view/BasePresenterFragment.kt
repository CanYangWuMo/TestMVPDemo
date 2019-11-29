package com.example.testmvpdemo.base.view

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.testmvpdemo.base.mvp.BaseContract
import com.example.testmvpdemo.base.mvp.BasePresenter

abstract class BasePresenterFragment<V : BaseContract.View, P : BasePresenter<V>> : Fragment(),
    BaseContract.View {

    protected var presenter:P? = null
    private var progressDialog = ProgressDialogFragment.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        presenter?.attachView(this as V)
    }

    override fun onDestroy() {
        presenter?.detachView()
        super.onDestroy()
    }

    abstract fun createPresenter(): P

    override fun showLoading() {
        var progressDialogFragment =
            childFragmentManager.findFragmentByTag(PROGRESS_DIALOG) as? ProgressDialogFragment
        if (progressDialogFragment == null) {
            progressDialog.show(childFragmentManager, PROGRESS_DIALOG)
        }
    }

    override fun hideLoading() {
        var progressDialogFragment =
            childFragmentManager.findFragmentByTag(PROGRESS_DIALOG) as? ProgressDialogFragment
        progressDialogFragment?.dismissAllowingStateLoss()
    }

    override fun close() {
    }

    protected fun isAttachActivity(): Boolean = activity != null

    companion object {
        const val PROGRESS_DIALOG = "PROGRESS_DIALOG"
    }
}