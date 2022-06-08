package ru.zavanton.demo.main.home

import android.util.Log
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    init {
        Log.d("zavanton", "zavanton - home view model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("zavanton", "zavanton - home onCleared")
    }
}
