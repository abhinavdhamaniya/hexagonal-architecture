package com.hexagonalArchitecture.feign.address.response

import com.hexagonalArchitecture.address.Address

data class AddressFeignWrapperResponse(
    val data: List<AddressFeignResponse>
) {
    constructor(): this(emptyList())
}

data class AddressFeignResponse(
    val streetName: String,
    val buildingNumber: String,
    val city: String
) {
    fun toAddress() = Address(streetName, buildingNumber, city)
}