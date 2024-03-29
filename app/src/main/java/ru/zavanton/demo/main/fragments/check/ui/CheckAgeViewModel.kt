package ru.zavanton.demo.main.fragments.check.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.zavanton.demo.main.fragments.check.business.ICheckAgeInteractor
import ru.zavanton.demo.main.fragments.check.di.CheckAgeComponentManager
import javax.inject.Inject

class CheckAgeViewModel(
    private val interactor: ICheckAgeInteractor,
) : ViewModel() {

    private val _ageLiveData = MutableLiveData<Int>()
    val ageLiveData: LiveData<Int> = _ageLiveData

    val userInput = MutableLiveData<String>()

    fun checkAge(name: String) {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                val age = interactor.checkAgeByName(name)

                withContext(Dispatchers.Main) {
                    _ageLiveData.value = age
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        CheckAgeComponentManager.clearComponent()
    }
}

class CheckAgeViewModelFactory @Inject constructor(
    private val interactor: ICheckAgeInteractor,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CheckAgeViewModel(interactor) as T
    }
}
