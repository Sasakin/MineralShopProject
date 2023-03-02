package com.chariot.mineral.shop.admin.controller

import com.chariot.mineral.shop.library.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class LoginController(val userService: UserService,
                      val passwordEncoder: BCryptPasswordEncoder? = null) {

    @GetMapping("/login")
    fun loginForm(model: Model): String {
        model.addAttribute("title", "Login")
        return "login"
    }

    @RequestMapping("/index", "/")
    fun home(model: Model): String {
        model.addAttribute("title", "Home Page")
        val authentication: Authentication? = SecurityContextHolder.getContext().authentication
        return if (authentication == null || authentication is AnonymousAuthenticationToken) {
            "redirect:/login"
        } else "index"
    }
}