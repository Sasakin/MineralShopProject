package com.chariot.mineral.shop.library.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint


@Entity
@Table(name = "products", uniqueConstraints = arrayOf(UniqueConstraint(columnNames = ["name", "image"])))
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var costPrice: Double = 0.0,
    var salePrice: Double = 0.0,
    var currentQuantity: Int = 0,

    @Lob
    @Column(columnDefinition = "BYTEA")
    var image: String? = null,

    @ManyToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    var category: Category? = null,
    var is_deleted: Boolean = false,
    var is_activated: Boolean = false)
