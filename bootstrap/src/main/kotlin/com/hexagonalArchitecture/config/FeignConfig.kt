package com.hexagonalArchitecture.config

import com.hexagonalArchitecture.feign.address.AddressFeignClient
import com.hexagonalArchitecture.feign.company.CompanyFeignClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(
    basePackageClasses = [
        CompanyFeignClient::class,
        AddressFeignClient::class
    ]
)
class FeignConfig