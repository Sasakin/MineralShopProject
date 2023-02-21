package com.chariot.mineral.shop.library.service

import com.chariot.mineral.shop.library.dto.AdminDto
import com.chariot.mineral.shop.library.model.Admin
import com.chariot.mineral.shop.library.repository.AdminRepository
import com.chariot.mineral.shop.library.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class AdminService(private val adminRepository: AdminRepository, private val roleRepository: RoleRepository) { // Внедряем репозиторий в качестве зависимости

    fun findByUsername(userName : String) : Admin = adminRepository.findByUsername(userName)

    fun save(adminDto : AdminDto) = run {
        val admin = Admin(
            firstName = adminDto.firstName,
            lastName = adminDto.lastName,
            username = adminDto.username,
            password =  adminDto.password,
            roles = listOf(roleRepository.findByName("ADMIN")))
        adminRepository.save(admin)
    }
}