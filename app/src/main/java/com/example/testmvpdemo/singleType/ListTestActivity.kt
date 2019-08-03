package com.example.testmvpdemo.singleType

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.testmvpdemo.R

class ListTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_type_list)
        showSingleTypePage()
    }

    private fun showSingleTypePage() {
        supportFragmentManager.beginTransaction()
            .add(R.id.content,SingleTypeListFragment.newInstance(), SINGLE_TYPE)
            .commit()
    }

    companion object {
        const val SINGLE_TYPE = "SINGLE_TYPE"
        fun getIntent(context: Context) = Intent(context, ListTestActivity::class.java).apply {
            //            putExtra()
        }
    }
}
