package com.example.singletondemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SV::class], version = 1, exportSchema = false)
abstract class SVDatabase : RoomDatabase() {

    abstract fun svDao(): SVDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: SVDatabase? = null

        fun getDatabase(context: Context): SVDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SVDatabase::class.java,
                    "sv_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}