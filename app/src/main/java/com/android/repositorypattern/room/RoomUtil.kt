package com.android.repositorypattern.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.repositorypattern.SampleDAO
import com.android.repositorypattern.SampleModel

@Database(entities = [SampleModel::class], version = 1, exportSchema = false)
abstract class RoomUtil : RoomDatabase() {
    companion object {
        private const val DB_NAME = "SampleDB"
        private lateinit var instance: RoomUtil

        fun init(context: Context) {
            instance = Room.databaseBuilder(
                    context,
                    RoomUtil::class.java,
                    DB_NAME
            ).allowMainThreadQueries()
                    .addMigrations()
                    .build()

            addData()
        }

        fun getInstance(): RoomUtil {
            return instance
        }


        fun addData() {
            getInstance().sampleDao().insertData(SampleModel(1, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(2, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(3, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(4, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(5, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(6, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(7, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(8, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(9, "John", "Smith"))
            getInstance().sampleDao().insertData(SampleModel(10, "John", "Smith"))
        }
    }

    abstract fun sampleDao(): SampleDAO
}