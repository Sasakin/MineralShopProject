package com.chariot.mineral.shop.library.dto

import jakarta.validation.constraints.Size

data class CustomerDto (
        @Size(min = 3, max = 15, message = "First name should have 3-15 characters")
        var firstName: String? = null,

        @Size(min = 3, max = 15, message = "Last name should have 3-15 characters")
        var lastName: String? = null,
        var username: String? = null,

        @Size(min = 5, max = 20, message = "Password should have 5-20 characters")
        var password: String? = null,
        var repeatPassword: String? = null)