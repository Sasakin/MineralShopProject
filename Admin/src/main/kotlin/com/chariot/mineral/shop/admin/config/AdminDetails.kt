package com.chariot.mineral.shop.admin.config

import com.chariot.mineral.shop.library.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class AdminDetails: UserDetails {

    val user: User = User()

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities: MutableList<SimpleGrantedAuthority> = ArrayList()
        for (role in user.roles) {
            authorities.add(SimpleGrantedAuthority(role.name))
        }
        return authorities
    }

    override fun getPassword(): String {
        return user.password;
    }

    override fun getUsername(): String {
        return user.username;
    }

    override fun isAccountNonExpired(): Boolean {
        return true;
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun isEnabled(): Boolean {
        return true;
    }
}
