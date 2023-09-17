package com.hexagonalArchitecture.company.provider

import com.hexagonalArchitecture.company.Company

interface CompanyProvider {
    fun getCompany(): Company
}