package ru.zavanton.demo.main.fragments.check.business

import javax.inject.Inject

class CheckAgeInteractor @Inject constructor(
) : ICheckAgeInteractor {

    override fun checkAgeByName(name: String): Int {
        return 123
    }
}
