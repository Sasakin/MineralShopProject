package com.chariot.mineral.shop.library.repository

import com.chariot.mineral.shop.library.model.Admin
import org.springframework.data.jpa.repository.JpaRepository

interface AdminRepository : JpaRepository<Admin, Long> {

    fun findByUsername(userName : String) : Admin

}