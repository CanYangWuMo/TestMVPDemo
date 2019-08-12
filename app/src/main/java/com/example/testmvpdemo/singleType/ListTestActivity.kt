package com.example.testmvpdemo.singleType

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.testmvpdemo.R

class ListTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_test)
//        showMultiTypePage()
        showSingleTypePage()
    }

    private fun showSingleTypePage() {
        supportFragmentManager.beginTransaction()
            .add(R.id.content, SingleTypeListFragment.newInstance(), SINGLE_TYPE)
            .commit()
    }

    private fun showMultiTypePage() {
        supportFragmentManager.beginTransaction()
            .add(R.id.content, MultiTypeListFragment.newInstance(), MULTI_TYPE)
            .commit()
    }

    companion object {
        const val SINGLE_TYPE = "SINGLE_TYPE"
        const val MULTI_TYPE = "MULTI_TYPE"
        fun getIntent(context: Context) = Intent(context, ListTestActivity::class.java).apply {
            //            putExtra()
        }
    }
}
