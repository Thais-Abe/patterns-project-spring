package com.project.thais.project_patterns_spring.controllers;

import com.project.thais.project_patterns_spring.models.Address;
import com.project.thais.project_patterns_spring.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {

    public final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @GetMapping("/{cep}/json/")
    public Address getByCep(@PathVariable String cep){
        return addressService.getByCep(cep);
    }
}
