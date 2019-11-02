package com.example.testmvpdemo.testmvp

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.testmvpdemo.R
import kotlinx.android.synthetic.main.activity_simple_mvp.*

class SimpleMVPActivity : AppCompatActivity(), Contract.View {
    private var presenter: TestPresenter<SimpleMVPActivity>? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_mvp)
        presenter?.attachView(this)
        text_test1?.text = ""
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("loading")
    }

    override fun onDestroy() {
        presenter?.detachView()
        super.onDestroy()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun hideLoading() {
        progressDialog?.hide()
    }

}
