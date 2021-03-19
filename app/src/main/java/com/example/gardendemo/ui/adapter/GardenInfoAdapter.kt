package com.example.gardendemo.ui.adapter

import android.content.Context

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.gardendemo.R
import com.example.gardendemo.network.response.GardenInfo
import com.example.gardendemo.tools.loadUrl

class GardenInfoAdapter(context: Context, val adapterClickListener: OnAdapterClickListener?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var adapterClick: OnAdapterClickListener? = null

    var mContext: Context = context
    var mDataSet: ArrayList<GardenInfo> = ArrayList()

    interface OnAdapterClickListener{
        fun OnItemClick(view: View?, position: Int)
    }

    fun swapDataSet(tempSet: ArrayList<GardenInfo>) {
        mDataSet.clear()
        tempSet.let {
            mDataSet.addAll(tempSet)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as GardenViewHolder

        if (adapterClickListener != null){
            adapterClick = adapterClickListener

            holder.itemView.setOnClickListener {
                adapterClick?.OnItemClick(it, position)
            }
        }

        holder.tv_gardenTitle.text = mDataSet[position].eName
        holder.tv_gardenInfo.text = mDataSet[position].eInfo
        holder.iv_gardenIcon.loadUrl(mDataSet[position].ePicURL)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.garden_item, parent, false)
        return GardenViewHolder(view)
    }

    class GardenViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        var iv_gardenIcon:ImageView = view.findViewById(R.id.iv_gardenIcon) as ImageView
        var tv_gardenTitle:TextView = view.findViewById(R.id.tv_gardenTitle) as TextView
        var tv_gardenInfo:TextView = view.findViewById(R.id.tv_gardenInfo) as TextView
    }
}
