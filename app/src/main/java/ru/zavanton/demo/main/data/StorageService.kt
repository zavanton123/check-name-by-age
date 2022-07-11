package ru.zavanton.demo.main.data

import android.content.SharedPreferences
import ru.zavanton.demo.EMPTY
import ru.zavanton.demo.main.data.model.StoragePerson
import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel
import javax.inject.Inject

class StorageService @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) : IStorageService {

    companion object {
        private const val NAME_KEY = "name"
        private const val AGE_KEY = "age"
    }

    override suspend fun saveLatestPerson(storagePerson: StoragePerson) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(NAME_KEY, storagePerson.name)
        editor.putInt(AGE_KEY, storagePerson.age ?: 0)
        editor.commit()
    }

    override suspend fun fetchLatestPerson(): StoragePerson {
        val name = sharedPreferences.getString(NAME_KEY, EMPTY) ?: EMPTY
        val age = sharedPreferences.getInt(AGE_KEY, 0) ?: 0
        return StoragePerson(name = name, age = age)
    }

    override suspend fun saveLatestQuery(personModel: PersonCheckDomainModel) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(NAME_KEY, personModel.name)
        editor.putInt(AGE_KEY, personModel.age)
        editor.commit()
    }

    override suspend fun fetchLatestQuery(): String {
        return sharedPreferences.getString(NAME_KEY, EMPTY) ?: EMPTY
    }
}
