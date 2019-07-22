package com.android.repositorypattern

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.repositorypattern.room.RoomUtil
import kotlinx.android.synthetic.main.activity_sample.*

class SampleActivity : AppCompatActivity() {

    private lateinit var viewModel: SampleViewModel
    private lateinit var adapter: SampleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        init()
        loadData()
    }


    private fun init() {
        RoomUtil.init(this)
        adapter = SampleAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(SampleViewModel::class.java)
        viewModel.mediatorLiveData.observe(this, Observer {
            adapter.setList(it)
            progressBar.gone()
            recyclerView.visible()
        })
    }

    private fun loadData() {
        viewModel.getList()
    }
}

private fun View.gone() {
    visibility = View.GONE
}

private fun View.visible() {
    visibility = View.VISIBLE
}
