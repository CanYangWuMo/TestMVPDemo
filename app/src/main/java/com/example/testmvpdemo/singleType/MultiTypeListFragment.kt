package com.example.testmvpdemo.singleType

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testmvpdemo.R
import com.example.testmvpdemo.adapter.MultiTypeAdapter
import com.example.testmvpdemo.adapter.TestSingleTypeModel
import com.example.testmvpdemo.adapter.model.TestEntity

class MultiTypeListFragment : Fragment() {
    private var listTest: RecyclerView? = null
    private var listData = ArrayList<TestEntity>()
    private var adapter = MultiTypeAdapter(listData)
    private var currentPage = 0
    private var TAG = "TAG"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_multi_type_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getView(view)
        initList()
    }

    private fun initList() {
        initListData()
//        adapter.setOnLoadMoreListener({
//            initListData()
//            Log.d(TAG, "Load More")
//        }, listTest)
        listTest?.layoutManager = LinearLayoutManager(context)
        listTest?.adapter = adapter
    }

    private fun initListData() {
        if (currentPage > 5) {
            Log.d(TAG, "more than 5 pages")
            return
        }
        var i = 0
        var j = 100
        while (i < 5) {
            var testSingleTypeModel = TestSingleTypeModel(i.toString(), j.toString())
            var testEntity1 = TestEntity().setEntityType1(testSingleTypeModel)
            var testEntity2 = TestEntity().setEntityType2(testSingleTypeModel)
            i++
            j++
            listData.add(testEntity1)
            listData.add(testEntity2)
        }
        currentPage++
    }

    private fun getView(view: View) {
        listTest = view.findViewById(R.id.list_multi_type)
    }

    companion object {
        fun newInstance() = MultiTypeListFragment()
    }
}