package com.example.testmvpdemo.testactionmvp

import android.os.Bundle
import com.example.testmvpdemo.R
import com.example.testmvpdemo.base.view.BaseActionPresenterActivity
import kotlinx.android.synthetic.main.activity_action_mvp.*

class ActionMVPActivity :
    BaseActionPresenterActivity<ActionMVPModel, ActionMVPContract.View, ActionMVPPresenter>()
    , ActionMVPContract.View {

    override fun createPresenter(): ActionMVPPresenter {
        return ActionMVPPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_mvp)
        text_test1?.text = "test Text"
        addListener()
    }

    private fun addListener() {
        btnSuccess?.setOnClickListener {
            presenter?.getData(SUCCESS)
        }
        btnFail?.setOnClickListener {
            presenter?.getData(FAIL)
        }
    }

    override fun showSuccess(data: String) {
        text_test1?.text = data
    }

    override fun showFail(data: String) {
        text_test1?.text = data
    }

    override fun showContent(model: ActionMVPModel) {

    }

    companion object {
        const val SUCCESS = "SUCCESS"
        const val FAIL = "FAIL"
    }
}
