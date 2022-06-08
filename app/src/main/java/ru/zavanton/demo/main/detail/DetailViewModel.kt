package ru.zavanton.demo.main.detail

import android.util.Log
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    init {
        Log.d("zavanton", "zavanton - detail view model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("zavanton", "zavanton - detail onCleared")
    }

    fun click() {
        Log.d("zavanton", "zavanton - detail click")
    }
}
