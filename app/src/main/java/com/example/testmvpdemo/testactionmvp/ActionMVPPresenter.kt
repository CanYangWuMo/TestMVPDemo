package com.example.testmvpdemo.testactionmvp

import android.os.Handler
import com.example.testmvpdemo.base.mvp.BaseActionPresenter

class ActionMVPPresenter :
    BaseActionPresenter<ActionMVPModel, ActionMVPContract.View>(ActionMVPModel::class.java),
    ActionMVPContract.Presenter {
    override fun doInit(isRestoring: Boolean) {

    }

    override fun getData(tag: String) {
        updateViewActionType1 { view?.showLoading() }
        Handler().postDelayed({
            when (tag) {
                ActionMVPActivity.SUCCESS -> {
                    updateViewActionType1 {
                        view?.hideLoading()
                        view?.showSuccess("Success Data")
                    }
                }
                ActionMVPActivity.FAIL -> {
                    updateViewActionType1 {
                        view?.hideLoading()
                        view?.showFail("Fail Data")
                    }
                }
                else -> {
                }
            }
        }, 2000)
    }
}