package com.example.gardendemo.network

import com.example.gardendemo.network.response.BaseResponse
import com.example.gardendemo.network.response.GardenInfoResponse
import com.example.gardendemo.network.response.PlantInfoResponse
import retrofit2.http.*

interface ApiService {
    @GET(NetworkConfig.API_GET_GARDEN_INFO)
    suspend fun getGardenInfo(@Query("q") q:String? = "", @Query("limit") limit:Int? = 1000, @Query("offset") offset:Int? = 0):BaseResponse<GardenInfoResponse>

    @GET(NetworkConfig.API_GET_PLANT_INFO)
    suspend fun getPlantInfo(@Query("q") q:String? = "", @Query("limit") limit:Int? = 1000, @Query("offset") offset:Int? = 0):BaseResponse<PlantInfoResponse>
}