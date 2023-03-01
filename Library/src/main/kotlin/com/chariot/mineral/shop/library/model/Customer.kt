package com.chariot.mineral.shop.library.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.Lob
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import jakarta.validation.constraints.Size


/**
 * User for B2С logic
 */
@Entity
@Table(name = "customers", uniqueConstraints = arrayOf(UniqueConstraint(columnNames = ["username", "image", "phone_number"])))
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    var id: Long? = null,

    @Size(min = 3, max = 15, message = "First name should have 3-15 characters")
    var firstName: String? = null,

    @Size(min = 3, max = 15, message = "Last name should have 3-15 characters")
    var lastName: String? = null,
    var username: String? = null,
    var country: String? = null,

    @Column(name = "phone_number")
    var phoneNumber: String? = null,
    var address: String? = null,
    var password: String? = null,

    @Lob
    @Column(columnDefinition = "BYTEA")
    var image: String? = null,

    @Column(name = "city")
    var city: String? = null,

    @OneToOne(mappedBy = "customer")
    var shoppingCart: ShoppingCart? = null,

    @OneToMany(mappedBy = "customer")
    var orders: List<Order>? = null,

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "customers_roles",
        joinColumns = [JoinColumn(name = "customer_id", referencedColumnName = "customer_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")]
    )
    var roles: Collection<Role>? = null)
