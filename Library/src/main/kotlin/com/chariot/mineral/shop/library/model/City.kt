package com.chariot.mineral.shop.library.model

import jakarta.persistence.*

@Entity
@Table(name = "cities")
data class City (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    val id: Long? = null,
    val name: String? = null)