package com.example.singletondemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowSVViewModel(application: Application): AndroidViewModel(application) {
    private val mDB = SVDatabase.getDatabase(application)
    val listStudent = MutableLiveData<List<SV>>(mutableListOf())

    fun getList() {
        viewModelScope.launch(Dispatchers.IO) {
            listStudent.postValue(mDB.svDao().getAllSV())
        }
    }

}