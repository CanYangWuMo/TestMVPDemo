package com.example.testmvpdemo.singleType

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.testmvpdemo.R
import com.example.testmvpdemo.adapter.SingleTypeAdapter
import com.example.testmvpdemo.adapter.TestSingleTypeModel
import kotlinx.android.synthetic.main.fragment_single_type_list.*

class SingleTypeListFragment : Fragment() {
    private var singleTypeList: RecyclerView? = null
    private var listData = ArrayList<TestSingleTypeModel>()
    private var listAdapter = SingleTypeAdapter(listData)
    private var btn1: Button? = null
    private var btn2: Button? = null
    private var targetTextView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_single_type_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView(view)
        initTestData()
        initListView()
        setAllListener()
    }

    private fun setAllListener() {
        btn1?.setOnClickListener {
            content.scrollTo(0, target_text.top)
        }
        btn2?.setOnClickListener {
            content.scrollTo(0, target_text.top)
        }
    }

    private fun initTestData() {
        var i = 0
        var j = 100
        while (i < 20) {
            var testSingleTypeModel = TestSingleTypeModel(i.toString(), j.toString())
            i++
            j++
            listData.add(testSingleTypeModel)
        }
    }

    private fun initListView() {
//        var headView = layoutInflater.inflate(R.layout.head_view_layout, null)
//        listAdapter.addHeaderView(headView)
        toolbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {

            }
        })
        var linearLayoutManager = LinearLayoutManager(context)
        singleTypeList?.layoutManager = linearLayoutManager
        singleTypeList?.adapter = listAdapter
    }

    private fun getView(view: View) {
        singleTypeList = view.findViewById(R.id.list_single_type)
        btn1 = view.findViewById(R.id.btn_scroll1)
        btn2 = view.findViewById(R.id.btn_scroll2)
        targetTextView = view.findViewById(R.id.target_text)
    }

    companion object {
        fun newInstance() = SingleTypeListFragment().apply {
            var bundle = Bundle()
//            bundle.putBinder()
            arguments = bundle
        }
    }
}