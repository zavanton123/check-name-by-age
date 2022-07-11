package ru.zavanton.demo.main.fragments.check.data.repository

import ru.zavanton.demo.EMPTY
import ru.zavanton.demo.app.di.FragmentScope
import ru.zavanton.demo.main.data.model.StoragePerson
import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel
import ru.zavanton.demo.main.fragments.check.data.model.PersonCheckDataModel
import javax.inject.Inject

@FragmentScope
class StorageDomainConverter @Inject constructor() {

    fun convertToCheckDomainModel(storagePerson: StoragePerson): PersonCheckDomainModel {
        return PersonCheckDomainModel(
            id = storagePerson.id,
            name = storagePerson.name ?: EMPTY,
            age = storagePerson.age ?: 0,
        )
    }

    fun convertToStoragePerson(personCheckDataModel: PersonCheckDataModel): StoragePerson {
        return StoragePerson(
            id = personCheckDataModel.id,
            name = personCheckDataModel.name,
            age = personCheckDataModel.age,
        )
    }
}
