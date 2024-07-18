package com.project.thais.project_patterns_spring.repositories;

import com.project.thais.project_patterns_spring.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, String> {
}
