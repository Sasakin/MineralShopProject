package com.charot.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = arrayOf("com.chariot.mineral.shop.library.*"))
@EnableJpaRepositories(value = arrayOf("com.chariot.mineral.shop.library.repository"))
@EntityScan(value = arrayOf("com.chariot.mineral.shop.library.model"))
class AdminApplication

fun main(args: Array<String>) {
	runApplication<AdminApplication>(*args)
}
