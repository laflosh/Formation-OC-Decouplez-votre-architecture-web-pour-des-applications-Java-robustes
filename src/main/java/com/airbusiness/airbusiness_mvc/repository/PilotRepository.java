package com.airbusiness.airbusiness_mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airbusiness.airbusiness_mvc.entities.Pilot;

@Repository
public interface PilotRepository extends CrudRepository<Pilot, Long> {

}
