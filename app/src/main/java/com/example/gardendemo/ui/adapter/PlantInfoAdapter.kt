package com.example.gardendemo.ui.adapter

import android.content.Context

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.gardendemo.R
import com.example.gardendemo.network.response.PlantInfo
import com.example.gardendemo.tools.loadUrl

class PlantInfoAdapter(context: Context, val adapterClickListener: OnAdapterClickListener?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var adapterClick: OnAdapterClickListener? = null

    var mContext: Context = context
    var mDataSet: ArrayList<PlantInfo> = ArrayList()

    interface OnAdapterClickListener{
        fun OnItemClick(view: View?, position: Int)
    }

    fun swapDataSet(tempSet: ArrayList<PlantInfo>) {
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
        holder as PlantInfoViewHolder

        if (adapterClickListener != null){
            adapterClick = adapterClickListener

            holder.itemView.setOnClickListener {
                adapterClick?.OnItemClick(it, position)
            }
        }

        mDataSet[position].fPic01URL?.let {
            holder.iv_plantIcon.loadUrl(it)
        }

        if (mDataSet[position].fNameCH!!.isEmpty()){
            holder.tv_plantTitle.text = mDataSet[position].fNameEn
        }else{
            holder.tv_plantTitle.text = mDataSet[position].fNameCH
        }

        holder.tv_plantInfo.text = mDataSet[position].fAlsoKnown
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.plant_item, parent, false)
        return PlantInfoViewHolder(view)
    }

    class PlantInfoViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        var iv_plantIcon:ImageView = view.findViewById(R.id.iv_plantIcon) as ImageView
        var tv_plantTitle:TextView = view.findViewById(R.id.tv_plantTitle) as TextView
        var tv_plantInfo:TextView = view.findViewById(R.id.tv_plantInfo) as TextView
    }
}
