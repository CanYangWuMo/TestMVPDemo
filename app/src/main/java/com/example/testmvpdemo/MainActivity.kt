package com.example.testmvpdemo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testmvpdemo.testbackend.TestBackEndService
import com.example.testmvpdemo.testactionmvp.ActionMVPActivity
import com.example.testmvpdemo.testactionmvp.fragment.ActionMVPFragment
import com.example.testmvpdemo.testbackend.TestApi
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_main?.setOnClickListener {

        }
    }

    /**
     * 接口测试
     */
    @SuppressLint("CheckResult")
    private fun testBackendService() {
        var testApi: TestApi = TestBackEndService.instance.createService(TestApi::class.java)
        testApi.getAd()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                Log.d("Ad", it.toString())
            }, {
                Log.d("Ad", it.message)
            })
    }

    private fun addActionMVPFragment() {
        if (supportFragmentManager.findFragmentByTag("TestMVP") == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.content, ActionMVPFragment.instance, "TestMVP")
                .commit()
        }
    }

    private fun startActionMVPActivity() {
        var intent = Intent()
        intent.setClass(this, ActionMVPActivity::class.java)
        startActivity(intent)
    }
}
