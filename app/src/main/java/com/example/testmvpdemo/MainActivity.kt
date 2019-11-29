package com.example.testmvpdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.testmvpdemo.testactionmvp.ActionMVPActivity
import com.example.testmvpdemo.testactionmvp.fragment.ActionMVPFragment
import com.example.testmvpdemo.testmvp.SimpleMVPActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_main?.setOnClickListener {

        }
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
