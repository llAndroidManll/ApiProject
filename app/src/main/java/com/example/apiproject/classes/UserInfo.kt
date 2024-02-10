package com.example.apiproject.classes

/*data class UserInfo(
    val countryName: String,
    val city: String,
    val locality: String,
)*/
data class GeoLocationResponse(
    val currency: Currency,
    val country_flag: String
)

data class Currency(
    val code: String,
    val name: String,
    val symbol: String
)



data class UserInfo(
    val latitude: Double = 0.0,
    val lookupSource: String = "",
    val longitude: Double = 0.0,
    val localityLanguageRequested: String = "",
    val continent: String = "",
    val continentCode: String = "",
    val countryName: String = "",
    val countryCode: String = "",
    val principalSubdivision: String = "",
    val principalSubdivisionCode: String = "",
    val city: String = "",
    val locality: String = "",
    val postcode: String = "",
    val plusCode: String = "",
    val localityInfo: LocalityInfo = LocalityInfo()
)

data class LocalityInfo(
    val administrative: List<AdministrativeInfo> = listOf(),
    val informative: List<InformativeInfo> = listOf()
)

data class AdministrativeInfo(
    val name: String = "",
    val description: String? = null,
    val isoName: String? = null,
    val order: Int = 0,
    val adminLevel: Int = 0,
    val isoCode: String? = null,
    val wikidataId: String? = null,
    val geonameId: Int = 0
)

data class InformativeInfo(
    val name: String = "",
    val description: String? = null,
    val isoName: String? = null,
    val order: Int = 0,
    val isoCode: String? = null,
    val wikidataId: String? = null,
    val geonameId: Int = 0
)

