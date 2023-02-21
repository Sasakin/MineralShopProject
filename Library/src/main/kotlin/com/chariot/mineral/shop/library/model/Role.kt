package com.chariot.mineral.shop.library.model

import jakarta.persistence.*

@Entity
@Table(name="roles")
data class Role(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @Column(name = "name", length = 200)
    var name: String = "",

)