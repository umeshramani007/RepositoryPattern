package com.android.repositorypattern

import androidx.lifecycle.LiveData
import com.android.repositorypattern.room.RoomUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class SampleRepository {

    //Suspend function will be executed on background thread
    suspend fun getList(): LiveData<List<SampleModel>> {
        return withContext(Dispatchers.IO) {
            delay(3000)

            //For this project, we have fetched data from sqlite database. However you can replace this with a webservice call.
            RoomUtil.getInstance().sampleDao().getList()
        }
    }
}