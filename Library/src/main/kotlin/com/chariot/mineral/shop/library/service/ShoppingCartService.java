package com.chariot.mineral.shop.library.service;

import com.chariot.mineral.shop.library.model.Customer;
import com.chariot.mineral.shop.library.model.Product;
import com.chariot.mineral.shop.library.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart addItemToCart(Product product, int quantity, Customer customer);

    ShoppingCart updateItemInCart(Product product, int quantity, Customer customer);

    ShoppingCart deleteItemFromCart(Product product, Customer customer);

}
