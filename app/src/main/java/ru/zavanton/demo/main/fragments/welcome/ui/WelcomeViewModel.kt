package ru.zavanton.demo.main.fragments.welcome.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.zavanton.demo.main.fragments.welcome.business.IWelcomeInteractor
import ru.zavanton.demo.main.fragments.welcome.di.WelcomeComponentManager
import javax.inject.Inject

class WelcomeViewModel(
    private val interactor: IWelcomeInteractor,
) : ViewModel() {

    private val _nameLiveData = MutableLiveData<String>()
    val nameLiveData: LiveData<String> = _nameLiveData

    init {
        Log.d("zavanton", "zavanton - home view model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("zavanton", "zavanton - home onCleared")
        WelcomeComponentManager.clearComponent()
    }

    fun fetchLatestName() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val name = interactor.fetchLatestName()
                Log.d("zavanton", "zavanton - name: $name")

                withContext(Dispatchers.Main) {
                    _nameLiveData.value = name
                }
            }
        }
    }
}

class WelcomeViewModelFactory @Inject constructor(
    private val interactor: IWelcomeInteractor,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WelcomeViewModel(interactor) as T
    }
}
