package ru.zavanton.demo.main.home

import android.util.Log
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Log.d("zavanton", "zavanton - home onCleared")
    }

    fun click() {
        Log.d("zavanton", "zavanton - button click")
    }
}
