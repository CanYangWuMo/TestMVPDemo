package com.example.testmvpdemo.singleType

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testmvpdemo.R
import kotlinx.android.synthetic.main.fragment_scroll.*

class ScrollFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scroll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_scroll1?.setOnClickListener {
            scrollView?.post {
                scrollView?.scrollTo(0, target1_text.top)
            }
        }
        btn_scroll2?.setOnClickListener {
            scrollView?.post {
                scrollView?.scrollTo(0, target2_text.top)
            }
        }
    }

    companion object {
        fun newInstance() = ScrollFragment()
    }
}