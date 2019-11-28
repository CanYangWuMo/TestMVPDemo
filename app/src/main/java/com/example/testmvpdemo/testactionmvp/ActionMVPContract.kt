package com.example.testmvpdemo.testactionmvp

import com.example.testmvpdemo.base.mvp.BaseContract

class ActionMVPContract {
    interface View : BaseContract.ViewWithModel<ActionMVPModel> {
        fun showSuccess(data: String)
        fun showFail(data: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun getData(tag:String)
    }
}