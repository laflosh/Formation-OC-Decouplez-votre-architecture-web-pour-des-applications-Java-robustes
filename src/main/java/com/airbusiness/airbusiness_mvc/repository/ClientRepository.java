package com.airbusiness.airbusiness_mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airbusiness.airbusiness_mvc.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}
