package com.android.repositorypattern

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface SampleDAO {
    @Query("SELECT * FROM sample_table")
    fun getList(): LiveData<List<SampleModel>>


    @Insert(onConflict = REPLACE)
    fun insertData(sampleModel: SampleModel)
}