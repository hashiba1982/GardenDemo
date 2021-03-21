package com.example.gardendemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gardendemo.R
import com.example.gardendemo.moduls.AppParam
import com.example.gardendemo.ui.adapter.GardenInfoAdapter
import com.example.gardendemo.vm.GardenInfoViewModel
import kotlinx.android.synthetic.main.garden_info_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class GardenInfoFragment : Fragment() {

    private val gardenInfoVM:GardenInfoViewModel by viewModel()
    private var mAdapter: GardenInfoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.garden_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObserver()
        initView()

        gardenInfoVM.getGardenInfoAPI()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar?.show()
    }

    private fun initView(){

        mAdapter = GardenInfoAdapter(
            requireContext(),
            object : GardenInfoAdapter.OnAdapterClickListener {
                override fun OnItemClick(view: View?, position: Int) {
                    val bundle = Bundle()
                    bundle.putString(AppParam.GARDEN_ICON, gardenInfoVM.gardenDataSet.value?.get(position)?.ePicURL)
                    bundle.putString(AppParam.GARDEN_CONTENT, gardenInfoVM.gardenDataSet.value?.get(position)?.eInfo)
                    bundle.putString(AppParam.GARDEN_TITLE, gardenInfoVM.gardenDataSet.value?.get(position)?.eName)
                    findNavController().navigate(
                        R.id.action_GardenInfoFragment_to_PlantInfoFragment,
                        bundle
                    )
                }
            })
        rv_gardenList.layoutManager = LinearLayoutManager(requireContext())
        rv_gardenList.adapter = mAdapter
    }

    private fun setObserver(){
        gardenInfoVM.gardenDataSet.observe(viewLifecycleOwner, {
            mAdapter?.swapDataSet(it)
        })
    }
}