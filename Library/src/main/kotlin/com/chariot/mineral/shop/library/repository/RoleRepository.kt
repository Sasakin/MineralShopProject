package com.chariot.mineral.shop.library.repository

import com.chariot.mineral.shop.library.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {

    fun findByName(name : String) : Role
}