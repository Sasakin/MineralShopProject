package com.chariot.mineral.shop.library.repository

import com.chariot.mineral.shop.library.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByUsername(userName : String) : User

}