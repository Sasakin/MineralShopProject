package com.chariot.mineral.shop.library.service

import com.chariot.mineral.shop.library.dto.UserDto
import com.chariot.mineral.shop.library.model.User
import com.chariot.mineral.shop.library.repository.UserRepository
import com.chariot.mineral.shop.library.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val roleRepository: RoleRepository) { // Внедряем репозиторий в качестве зависимости

    fun findByUsername(userName : String) : User = userRepository.findByUsername(userName)

    fun save(userDto : UserDto) = run {
        val user = User(
            firstName = userDto.firstName,
            lastName = userDto.lastName,
            username = userDto.username,
            password =  userDto.password,
            roles = listOf(roleRepository.findByName("ADMIN")))
        userRepository.save(user)
    }
}