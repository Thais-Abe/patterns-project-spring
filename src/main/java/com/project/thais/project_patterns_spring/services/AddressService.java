package com.project.thais.project_patterns_spring.services;

import com.project.thais.project_patterns_spring.models.Address;
import com.project.thais.project_patterns_spring.models.IAddress;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final IAddress iAddress;

    public AddressService(IAddress iAddress) {
        this.iAddress = iAddress;
    }

    public Address getByCep(String cep){
        return iAddress.verifyCep(cep);
    }
}
