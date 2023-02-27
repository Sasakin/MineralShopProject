package com.chariot.mineral.shop.admin.config

import com.chariot.mineral.shop.library.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
internal class AdminServiceConfig : UserDetailsService {
    @Autowired
    private val userRepository: UserRepository? = null

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val admin = userRepository!!.findByUsername(username)
            ?: throw UsernameNotFoundException("Could not find username")
        return User(
            admin.username,
            admin.password,
            admin.roles
                .stream()
                .map { role -> SimpleGrantedAuthority(role.name) }.collect(Collectors.toList())
        )
    }
}