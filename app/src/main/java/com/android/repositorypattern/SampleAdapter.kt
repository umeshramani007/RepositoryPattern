package com.android.repositorypattern

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter(private val context: Context) : RecyclerView.Adapter<SampleViewHolder>() {
    private var list: List<SampleModel>? = null

    fun setList(list: List<SampleModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        return SampleViewHolder(
                DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_sample_adapter, null, false)
        )
    }

    override fun getItemCount(): Int {
        return if (list == null) return 0 else list!!.size
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.binding.setVariable(BR.sampleModel, list!![position])
    }
}