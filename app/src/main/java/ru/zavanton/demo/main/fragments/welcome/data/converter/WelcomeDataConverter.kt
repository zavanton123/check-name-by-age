package ru.zavanton.demo.main.fragments.welcome.data.converter

import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.data.model.StoragePerson
import ru.zavanton.demo.main.fragments.welcome.domain.model.PersonWelcomeDomainModel
import ru.zavanton.utils.EMPTY
import javax.inject.Inject

@FragmentScope
class WelcomeDataConverter @Inject constructor() {

    fun convertToDomain(person: StoragePerson): PersonWelcomeDomainModel {
        return PersonWelcomeDomainModel(
            id = person.id,
            name = person.name ?: EMPTY,
            age = person.age ?: 0,
        )
    }
}
