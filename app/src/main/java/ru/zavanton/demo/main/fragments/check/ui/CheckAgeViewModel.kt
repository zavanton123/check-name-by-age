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
import ru.zavanton.demo.main.fragments.check.ui.model.DomainToUiConverter
import ru.zavanton.demo.main.fragments.check.ui.model.PersonCheckUiModel
import javax.inject.Inject

class CheckAgeViewModel(
    private val interactor: ICheckAgeInteractor,
    private val converter: DomainToUiConverter,
) : ViewModel() {

    private val _personUiModel = MutableLiveData<PersonCheckUiModel>()
    val personUiModel: LiveData<PersonCheckUiModel> = _personUiModel

    fun checkAge(name: String) {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                val personCheckDomainModel = interactor.checkAgeByName(name)

                val personCheckUiModel: PersonCheckUiModel =
                    converter.convertToUiModel(personCheckDomainModel)


                withContext(Dispatchers.Main) {
                    _personUiModel.value = personCheckUiModel
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
    private val converter: DomainToUiConverter,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CheckAgeViewModel(interactor, converter) as T
    }
}
