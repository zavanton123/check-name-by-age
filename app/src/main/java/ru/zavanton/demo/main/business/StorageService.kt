package ru.zavanton.demo.main.business

import android.content.SharedPreferences
import ru.zavanton.demo.main.fragments.check.business.model.PersonModel
import javax.inject.Inject

class StorageService @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : IStorageService {

    companion object {
        const val EMPTY = ""
        private const val NAME_KEY = "name"
        private const val AGE_KEY = "age"
    }

    override suspend fun saveLatestQuery(personModel: PersonModel) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(NAME_KEY, personModel.name)
        editor.putInt(AGE_KEY, personModel.age)
        editor.commit()
    }

    override suspend fun fetchLatestQuery(): String {
        return sharedPreferences.getString(NAME_KEY, EMPTY) ?: EMPTY
    }
}
