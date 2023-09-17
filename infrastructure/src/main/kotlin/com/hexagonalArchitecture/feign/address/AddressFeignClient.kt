package com.hexagonalArchitecture.feign.address

import com.hexagonalArchitecture.feign.address.response.AddressFeignWrapperResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "address",
    url = "\${feign.address.url}"
)
interface AddressFeignClient {

    @GetMapping("api/v1/addresses?_quantity=1")
    fun getAddress(): AddressFeignWrapperResponse
}