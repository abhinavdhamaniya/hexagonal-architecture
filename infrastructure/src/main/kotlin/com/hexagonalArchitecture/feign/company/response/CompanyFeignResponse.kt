package com.hexagonalArchitecture.feign.company.response

import com.hexagonalArchitecture.company.Company

data class CompanyFeignWrapperResponse(
    val data: List<CompanyFeignResponse>
) {
    constructor(): this(emptyList())
}

data class CompanyFeignResponse(
    val name: String,
    val email: String,
    val website: String
) {
    fun toCompany() = Company(name, email, website)
}