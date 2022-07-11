package ru.zavanton.demo.main.fragments.welcome.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.zavanton.demo.main.fragments.welcome.di.WelcomeComponentManager
import ru.zavanton.demo.main.fragments.welcome.domain.IWelcomeInteractor
import ru.zavanton.demo.main.fragments.welcome.ui.model.PersonWelcomeUiModel
import ru.zavanton.demo.main.fragments.welcome.ui.model.WelcomeUiConverter
import javax.inject.Inject

class WelcomeViewModel(
    private val interactor: IWelcomeInteractor,
    private val converter: WelcomeUiConverter,
) : ViewModel() {

    private val _personWelcomeUiModel = MutableLiveData<PersonWelcomeUiModel>()
    val personWelcomeUiModel: LiveData<PersonWelcomeUiModel> = _personWelcomeUiModel

    fun fetchLatestName() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val personWelcomeDomainModel = interactor.fetchLatestName()

                val uiModel: PersonWelcomeUiModel = converter.convertToUi(personWelcomeDomainModel)

                withContext(Dispatchers.Main) {
                    _personWelcomeUiModel.value = uiModel
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
    private val converter: WelcomeUiConverter,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WelcomeViewModel(interactor, converter) as T
    }
}
