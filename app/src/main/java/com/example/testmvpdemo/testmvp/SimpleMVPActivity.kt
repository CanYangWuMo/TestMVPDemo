package com.example.testmvpdemo.testmvp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testmvpdemo.R
import kotlinx.android.synthetic.main.activity_simple_mvp.*

class SimpleMVPActivity : AppCompatActivity(), Contract.View {
    private var presenter: SimpleMVPPresenter<SimpleMVPActivity>? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_mvp)
        presenter = SimpleMVPPresenter()
        presenter?.attachView(this)
        text_test1?.text = "test Text"
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("loading")
        addListener()
    }

    private fun addListener() {
        btnSuccess?.setOnClickListener {
            presenter?.getData(Model.SUCCESS)
        }
        btnFail?.setOnClickListener {
            presenter?.getData(Model.FAIL)
        }
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

    override fun showSuccess(data:String) {
        text_test1?.text = data
    }

    override fun showFail(data:String) {
        text_test1?.text = data
    }

}
