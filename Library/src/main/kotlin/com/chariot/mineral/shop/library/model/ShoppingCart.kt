package com.chariot.mineral.shop.library.model

import jakarta.persistence.*


@Entity
@Table(name = "shopping_cart")
data class ShoppingCart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    var id: Long? = null,
    var totalItems: Int = 0,
    var totalPrices: Double = 0.0,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    var customer: Customer? = null,

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "cart")
    var cartItem: Set<CartItem>? = null)