package com.example.gardendemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardendemo.R
import com.example.gardendemo.tools.loadUrl
import com.example.gardendemo.ui.adapter.PlantInfoAdapter
import com.example.gardendemo.vm.PlantInfoViewModel
import kotlinx.android.synthetic.main.plant_info_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlantDetailFragment : Fragment() {

    private var gardenIcon: String? = ""
    private var gardenContent: String? = ""

    private val plantInfoVM:PlantInfoViewModel by viewModel()
    private var mAdapter: PlantInfoAdapter? = null

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
            gardenIcon = it.getString("gardenIcon")
            gardenContent = it.getString("gardenContent")
        }

        setObserver()
        initView()

        plantInfoVM.getPlantInfoAPI()
    }

    private fun initView(){

        gardenIcon?.let {
            iv_gardenIconInside.loadUrl(it)
        }

        gardenContent?.let {
            tv_gardenInfoInside.text = gardenContent
        }

        mAdapter = PlantInfoAdapter(requireContext(), object : PlantInfoAdapter.OnAdapterClickListener{
            override fun OnItemClick(view: View?, position: Int) {

            }
        })

        rv_plantList.layoutManager = LinearLayoutManager(requireContext())
        rv_plantList.adapter = mAdapter
    }

    private fun setObserver(){
        plantInfoVM.plantDataSet.observe(viewLifecycleOwner, {
            mAdapter?.swapDataSet(it)
        })
    }
}