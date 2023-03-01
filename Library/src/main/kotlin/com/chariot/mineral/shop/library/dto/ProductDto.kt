package com.chariot.mineral.shop.library.dto

import com.chariot.mineral.shop.library.model.Category

data class ProductDto (
    var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var costPrice: Double = 0.0,
    var salePrice: Double = 0.0,
    var currentQuantity: Int = 0,
    var category: Category? = null,
    var image: String? = null,
    var activated: Boolean = false,
    var deleted: Boolean = false)