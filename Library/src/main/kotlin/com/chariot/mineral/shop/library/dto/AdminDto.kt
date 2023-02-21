package com.chariot.mineral.shop.library.dto

import jakarta.validation.constraints.Size

class AdminDto {

    @Size(min = 3, max = 24, message = "Invalid first name")
    var firstName: String = ""

    @Size(min = 3, max = 24, message = "Invalid last name")
    var lastName: String = ""

    @Size(min = 3, max = 24, message = "Invalid username")
    var username: String = ""

    var password: String = ""

    var repeatPassword: String = ""
}