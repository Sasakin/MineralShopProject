package com.chariot.mineral.shop.admin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
internal class AdminConfiguration {
    @Bean
    fun userDetailsService(): UserDetailsService {
        return AdminServiceConfig()
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun daoAuthenticationProvider(passwordEncoder: PasswordEncoder, userDetailsService: UserDetailsService): DaoAuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(userDetailsService)
        provider.setPasswordEncoder(passwordEncoder)
        return provider
    }

    @Bean
    @Throws(java.lang.Exception::class)
    fun filterChain(http: HttpSecurity, authenticationProvider: DaoAuthenticationProvider): SecurityFilterChain? {
        http.authenticationProvider(authenticationProvider);
        http.authorizeHttpRequests()
            .requestMatchers("/**")
            .permitAll()
            .requestMatchers("/admin/**")
            .hasAuthority("ADMIN")
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/do-login")
            .defaultSuccessUrl("/index")
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        http.headers().frameOptions().sameOrigin()
        return http.build()
    }
}