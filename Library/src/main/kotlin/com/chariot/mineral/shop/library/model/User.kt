package com.chariot.mineral.shop.library.model

import jakarta.persistence.*

/**
 * User for B2B logic
 */
@Entity
@Table(name="users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0L,

    var firstName: String = "",

    var lastName: String = "",

    var username: String = "",

    var password: String = "",

    @Lob
    @Column(columnDefinition = "BYTEA")
    var image: String = "",

    @ManyToMany(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "users_roles", joinColumns = arrayOf(JoinColumn(name="user_id", referencedColumnName = "id")),
    inverseJoinColumns = arrayOf(JoinColumn(name="role_id", referencedColumnName = "id")))
    var roles: List<Role> = emptyList()

)