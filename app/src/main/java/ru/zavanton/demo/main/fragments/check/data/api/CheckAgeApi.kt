package ru.zavanton.demo.main.fragments.check.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.zavanton.demo.main.fragments.check.business.model.PersonCheckDomainModel

interface CheckAgeApi {

    @GET("/")
    suspend fun fetchInfo(@Query("name") name: String): PersonCheckDomainModel
}
