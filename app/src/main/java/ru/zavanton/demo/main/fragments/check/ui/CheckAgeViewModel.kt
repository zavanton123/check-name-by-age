package ru.zavanton.demo.main.fragments.check.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.zavanton.demo.main.fragments.check.business.ICheckAgeInteractor
import javax.inject.Inject

class CheckAgeViewModel(
    private val interactor: ICheckAgeInteractor,
) : ViewModel() {

    init {
        Log.d("zavanton", "zavanton - detail view model created")
        Log.d("zavanton", "zavanton - interactor: ${interactor.checkAgeByName("hello")}")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("zavanton", "zavanton - detail onCleared")
    }

    fun click() {
        Log.d("zavanton", "zavanton - detail click")
    }
}

class CheckAgeViewModelFactory @Inject constructor(
    private val interactor: ICheckAgeInteractor,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CheckAgeViewModel(interactor) as T
    }
}