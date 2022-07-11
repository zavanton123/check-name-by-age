package ru.zavanton.demo.main.fragments.check.ui.model

import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.fragments.check.domain.model.PersonCheckDomainModel
import javax.inject.Inject

@FragmentScope
class CheckUiConverter @Inject constructor() {

    fun convertToUiModel(person: PersonCheckDomainModel): PersonCheckUiModel {
        return PersonCheckUiModel(
            id = person.id,
            name = person.name,
            age = person.age
        )
    }
}
