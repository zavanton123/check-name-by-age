package ru.zavanton.demo.main.fragments.welcome.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.zavanton.demo.EMPTY
import ru.zavanton.demo.main.fragments.welcome.business.IWelcomeInteractor
import ru.zavanton.demo.main.fragments.welcome.di.WelcomeComponentManager
import javax.inject.Inject

class WelcomeViewModel(
    private val interactor: IWelcomeInteractor,
) : ViewModel() {

    private val _nameLiveData = MutableLiveData(EMPTY)
    val nameLiveData: LiveData<String> = _nameLiveData

    fun fetchLatestName() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val name = interactor.fetchLatestName()

                withContext(Dispatchers.Main) {
                    _nameLiveData.value = name
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        WelcomeComponentManager.clearComponent()
    }
}

class WelcomeViewModelFactory @Inject constructor(
    private val interactor: IWelcomeInteractor,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WelcomeViewModel(interactor) as T
    }
}
