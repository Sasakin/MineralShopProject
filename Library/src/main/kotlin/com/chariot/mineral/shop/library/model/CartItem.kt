package com.chariot.mineral.shop.library.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table


@Entity
@Table(name = "cart_item")
data class CartItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    var quantity: Int = 0,
    var totalPrice: Double = 0.0,

    @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "shopping_cart_id")
    var cart: ShoppingCart? = null,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    var product: Product? = null)
