package com.address.app.addressapp.controller;

import com.address.app.addressapp.service.Address;
import com.address.app.addressapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/randomizer/address")
    public Address getAddress(){
        return addressService.getRandomAddress();
    }

}
