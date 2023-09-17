package com.hexagonalArchitecture.address.provider

import com.hexagonalArchitecture.address.Address

interface AddressProvider {
    fun getAddress(): Address
}