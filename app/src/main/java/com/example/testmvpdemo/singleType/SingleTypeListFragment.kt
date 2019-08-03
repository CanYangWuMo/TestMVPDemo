package com.example.testmvpdemo.singleType

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testmvpdemo.R
import com.example.testmvpdemo.adapter.SingleTypeAdapter
import com.example.testmvpdemo.adapter.TestSingleTypeModel

class SingleTypeListFragment : Fragment() {
    private var singleTypeList: RecyclerView? = null
    private var listData = ArrayList<TestSingleTypeModel>()
    private var listAdapter = SingleTypeAdapter(listData)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_single_type_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView(view)
        initTestData()
        initListView()
    }

    private fun initTestData() {
        var i = 0
        var j = 100
        while (i < 10) {
            var testSingleTypeModel = TestSingleTypeModel(i.toString(), j.toString())
            i++
            j++
            listData.add(testSingleTypeModel)
        }
    }

    private fun initListView() {
        var linearLayoutManager = LinearLayoutManager(context)
        singleTypeList?.layoutManager = linearLayoutManager
        singleTypeList?.adapter = listAdapter
    }

    private fun getView(view: View) {
        singleTypeList = view.findViewById(R.id.list_single_type)
    }

    companion object {
        fun newInstance() = SingleTypeListFragment().apply {
            var bundle = Bundle()
//            bundle.putBinder()
            arguments = bundle
        }
    }
}