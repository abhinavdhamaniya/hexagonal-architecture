package com.hexagonalArchitecture.feign.address.adapter

import com.hexagonalArchitecture.address.Address
import com.hexagonalArchitecture.address.provider.AddressProvider
import com.hexagonalArchitecture.feign.address.AddressFeignClient
import org.springframework.beans.factory.annotation.Autowired

class AddressAdapter: AddressProvider {

    @Autowired
    private lateinit var client: AddressFeignClient

    override fun getAddress(): Address {
        return client.getAddress().data.first().toAddress()
    }
}