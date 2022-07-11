package ru.zavanton.demo.main.fragments.welcome.ui.model

import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.fragments.welcome.domain.model.PersonWelcomeDomainModel
import javax.inject.Inject

@FragmentScope
class WelcomeUiConverter @Inject constructor() {

    fun convertToUi(person: PersonWelcomeDomainModel): PersonWelcomeUiModel {
        return PersonWelcomeUiModel(
            id = person.id,
            name = person.name,
            age = person.age,
        )
    }
}
