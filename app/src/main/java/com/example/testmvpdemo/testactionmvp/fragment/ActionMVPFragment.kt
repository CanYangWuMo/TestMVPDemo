package com.example.testmvpdemo.testactionmvp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testmvpdemo.R
import com.example.testmvpdemo.base.view.BaseActionPresenterFragment
import com.example.testmvpdemo.testactionmvp.ActionMVPActivity
import com.example.testmvpdemo.testactionmvp.ActionMVPContract
import com.example.testmvpdemo.testactionmvp.ActionMVPModel
import com.example.testmvpdemo.testactionmvp.ActionMVPPresenter
import kotlinx.android.synthetic.main.activity_action_mvp.*

class ActionMVPFragment :
    BaseActionPresenterFragment<ActionMVPModel, ActionMVPContract.View, ActionMVPPresenter>(),
    ActionMVPContract.View {

    override fun createPresenter(): ActionMVPPresenter {
        return ActionMVPPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_action_mvp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_test1?.text = "test Text"
        addListener()
    }

    private fun addListener() {
        btnSuccess?.setOnClickListener {
            presenter?.getData(ActionMVPActivity.SUCCESS)
        }
        btnFail?.setOnClickListener {
            presenter?.getData(ActionMVPActivity.FAIL)
        }
    }

    override fun showSuccess(data: String) {
        text_test1?.text = data
    }

    override fun showFail(data: String) {
        text_test1?.text = data
    }


    override fun close() {
    }

    companion object{
        var instance = ActionMVPFragment()
    }
}