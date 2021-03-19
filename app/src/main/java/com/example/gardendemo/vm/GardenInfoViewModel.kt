package com.example.gardendemo.vm

import androidx.lifecycle.MutableLiveData
import com.example.gardendemo.network.RetrofitClient
import com.example.gardendemo.network.response.GardenInfo

class GardenInfoViewModel() : BaseViewModel() {

    var gardenDataSet = MutableLiveData<ArrayList<GardenInfo>>()

    fun getGardenInfoAPI() {
        launchAPI({
            var gardenInfoResponse = RetrofitClient().create().getGardenInfo()
            gardenDataSet.value = gardenInfoResponse.result?.results
        }, {

        })
    }
}