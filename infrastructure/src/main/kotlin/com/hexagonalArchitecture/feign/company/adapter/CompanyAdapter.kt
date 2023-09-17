package com.hexagonalArchitecture.feign.company.adapter

import com.hexagonalArchitecture.company.Company
import com.hexagonalArchitecture.company.provider.CompanyProvider
import com.hexagonalArchitecture.feign.company.CompanyFeignClient
import org.springframework.beans.factory.annotation.Autowired

class CompanyAdapter: CompanyProvider {

    @Autowired
    private lateinit var client: CompanyFeignClient

    override fun getCompany(): Company {
        return client.getCompany().data.first().toCompany()
    }
}