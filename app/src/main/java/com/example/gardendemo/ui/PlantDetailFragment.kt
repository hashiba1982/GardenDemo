package com.example.gardendemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gardendemo.R
import com.example.gardendemo.moduls.AppParam
import com.example.gardendemo.network.response.PlantInfo
import com.example.gardendemo.tools.loadUrl
import kotlinx.android.synthetic.main.plant_detail_fragment.*

class PlantDetailFragment : Fragment() {

    private var plantItem:PlantInfo = PlantInfo()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.plant_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            plantItem = it.getParcelable<PlantInfo>(AppParam.PLANT_ITEM)!!
        }

        initView()
    }

    private fun initView(){
        plantItem.fPic01URL?.let {
            iv_plantImage.loadUrl(it)
        }

        tv_name.text = plantItem.fNameEn
        tv_otherName.text = plantItem.fAlsoKnown
        tv_info.text = plantItem.fBrief
        tv_identify.text = plantItem.fFeature
        tv_function.text = plantItem.fFunction
        tv_lastUpdate.text = getString(R.string.last_update)+plantItem.fUpdate
    }


}