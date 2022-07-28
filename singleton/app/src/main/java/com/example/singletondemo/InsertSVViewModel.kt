package com.example.singletondemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InsertSVViewModel(application: Application): AndroidViewModel(application) {
    private val mDB = SVDatabase.getDatabase(application)

    fun insert(sv: SV){
        viewModelScope.launch(Dispatchers.IO) {
            mDB.svDao().insertSV(sv)
        }
    }
}