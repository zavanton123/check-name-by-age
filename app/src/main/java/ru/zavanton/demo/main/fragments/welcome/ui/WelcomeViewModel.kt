package ru.zavanton.demo.main.fragments.welcome.ui

import android.util.Log
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    init {
        Log.d("zavanton", "zavanton - home view model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("zavanton", "zavanton - home onCleared")
    }
}
