package com.example.gardendemo.vm

import androidx.lifecycle.MutableLiveData
import com.example.gardendemo.network.RetrofitClient
import com.example.gardendemo.network.response.PlantInfo

class PlantInfoViewModel() : BaseViewModel() {

    var plantDataSet = MutableLiveData<ArrayList<PlantInfo>>()

    fun getPlantInfoAPI() {
        launchAPI({
            var plantInfoResponse = RetrofitClient().create().getPlantInfo()
            plantDataSet.value = plantInfoResponse.result?.results
        }, {

        })
    }
}