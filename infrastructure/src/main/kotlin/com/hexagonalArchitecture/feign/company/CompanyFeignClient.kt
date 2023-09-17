package com.hexagonalArchitecture.feign.company

import com.hexagonalArchitecture.feign.company.response.CompanyFeignWrapperResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "company",
    url = "\${feign.company.url}"
)
interface CompanyFeignClient {

    @GetMapping("api/v1/companies?_quantity=1")
    fun getCompany(): CompanyFeignWrapperResponse
}