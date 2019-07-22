package com.android.repositorypattern

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample_table")
data class SampleModel(@PrimaryKey(autoGenerate = true) val id:Int, val fName: String, val lName: String)