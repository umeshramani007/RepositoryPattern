package com.android.repositorypattern

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class SampleViewModel : ViewModel() {

    private val repo = SampleRepository()

    val mediatorLiveData = MediatorLiveData<List<SampleModel>>()

    fun getList() {

        //We will use coroutine instead of Thread to get data in background.
        //Code in launch body will be executed in main thread.
        //However, we have used suspend function in Repository class to get data in background thread.
        (CoroutineScope(Dispatchers.Main) + Job()).launch {
            mediatorLiveData.addSource(repo.getList()) {
                mediatorLiveData.value = (it)
            }
        }
    }
}