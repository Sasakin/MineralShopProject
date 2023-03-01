package com.chariot.mineral.shop.library.model

import jakarta.persistence.*


@Entity
@Table(name = "order_detail")
data class OrderDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    val id: Long? = null,
    val quantity: Int = 0,
    val totalPrice: Double = 0.0,
    val unitPrice: Double = 0.0,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    val order: Order? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    val product: Product? = null)