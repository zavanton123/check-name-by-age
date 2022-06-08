package ru.zavanton.demo.main.detail

import android.util.Log
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Log.d("zavanton", "zavanton - detail onCleared")
    }

    fun click() {
        Log.d("zavanton", "zavanton - detail click")
    }
}
