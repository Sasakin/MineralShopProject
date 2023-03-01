package com.chariot.mineral.shop.library.model

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    val id: Long? = null,
    val orderDate: Date? = null,
    val deliveryDate: Date? = null,
    val totalPrice: Double = 0.0,
    val shippingFee: Double = 0.0,
    val orderStatus: String? = null,
    val notes: String? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    val customer: Customer? = null,

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "order")
    val orderDetailList: List<OrderDetail>? = null)