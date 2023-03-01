package com.chariot.mineral.shop.library.service;

import com.chariot.mineral.shop.library.dto.CustomerDto;
import com.chariot.mineral.shop.library.model.Customer;

public interface CustomerService {

    CustomerDto save(CustomerDto customerDto);

    Customer findByUsername(String username);

    Customer saveInfo(Customer customer);
}
