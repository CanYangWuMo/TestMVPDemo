package com.example.testmvpdemo.base.view

import com.example.testmvpdemo.base.mvp.BaseActionPresenter
import com.example.testmvpdemo.base.mvp.BaseContract

abstract class BaseActionPresenterActivity<M:Any,V:BaseContract.ViewWithModel<M>,P:BaseActionPresenter<M,V>>
    :BaseContract.ViewWithModel<M>,BaseActivity() {
    override fun showContent(model: M) {

    }
}