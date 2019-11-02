package com.example.testmvpdemo.testmvp

class TestPresenter<T : Contract.View> : Contract.Presenter<T> {
    private var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }
    private fun isAttachView():Boolean{
        return view!=null
    }
}