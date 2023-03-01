package com.chariot.mineral.shop.library.service.impl;

import com.chariot.mineral.shop.library.model.City;
import com.chariot.mineral.shop.library.repository.CityRepository;
import com.chariot.mineral.shop.library.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
