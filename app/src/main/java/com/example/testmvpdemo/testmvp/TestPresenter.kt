package com.example.testmvpdemo.testmvp

class TestPresenter<T : Contract.View> : Contract.Presenter<T>, Contract.ModelCallBack {
    private var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    private fun isAttachView(): Boolean {
        return view != null
    }

    override fun onError(data: String) {
        view?.hideLoading()
        view?.showFail(data)
    }

    override fun onSuccess(data: String) {
        view?.hideLoading()
        view?.showSuccess(data)
    }

    override fun getData(data: String) {
        view?.showLoading()
        Model().getData(data, this)
    }
}