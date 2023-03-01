package com.chariot.mineral.shop.library.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(name = "categories", uniqueConstraints = arrayOf(UniqueConstraint(columnNames = arrayOf("name"))))
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val id: Long? = null,
    var name: String? = null,
    @Column(name = "is_deleted")
    var isDeleted: Boolean = false,
    @Column(name = "is_activated")
    var isActivated: Boolean = false) {

    constructor(Name: String) : this() {
        this.name = name
        isActivated = true
        isDeleted = false
    }

}