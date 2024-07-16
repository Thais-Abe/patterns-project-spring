package com.project.thais.project_patterns_spring.models;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address", url = "https://viacep.com.br/ws")
public interface IAddress {

    @GetMapping("/{cep}/json/")
    Address verifyCep(@PathVariable("cep") String cep);
}
