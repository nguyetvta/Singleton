package com.example.singletondemo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SVDao {
    @Insert
    fun insertSV(sv: SV)

    @Query("select * from table_sv")
    fun getAllSV(): MutableList<SV>
}