package com.example.gardendemo.moduls

import com.example.gardendemo.vm.GardenInfoViewModel
import com.example.gardendemo.vm.PlantInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gModule = module{
    viewModel { GardenInfoViewModel() }
    viewModel { PlantInfoViewModel() }
}