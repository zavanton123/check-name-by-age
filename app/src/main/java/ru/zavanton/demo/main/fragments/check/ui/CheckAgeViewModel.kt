package ru.zavanton.demo.main.fragments.check.ui

import android.util.Log
import androidx.lifecycle.ViewModel

class CheckAgeViewModel : ViewModel() {

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
