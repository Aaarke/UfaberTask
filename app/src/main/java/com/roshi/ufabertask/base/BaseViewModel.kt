package com.roshi.ufabertask.base

import androidx.lifecycle.ViewModel
import com.roshi.ufabertask.contributor.ContriButorViewModel

import com.roshi.ufabertask.di.ApiComponent
import com.roshi.ufabertask.di.DaggerApiComponent
import com.roshi.ufabertask.di.NetworkModule
import com.roshi.ufabertask.home.HomeViewModel
import com.roshi.ufabertask.repowner.RepoOwnerViewModel


abstract class BaseViewModel : ViewModel() {


    private val injector: ApiComponent = DaggerApiComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is HomeViewModel -> {
                injector.inject(this)
            }

            is ContriButorViewModel->{
                injector.inject(this )
            }

            is RepoOwnerViewModel->{
                injector.inject(this )
            }

        }
    }
}