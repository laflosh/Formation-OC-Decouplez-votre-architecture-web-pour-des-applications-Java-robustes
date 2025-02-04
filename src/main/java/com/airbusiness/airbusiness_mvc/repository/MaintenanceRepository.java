package com.airbusiness.airbusiness_mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airbusiness.airbusiness_mvc.entities.MaintenanceIssue;

@Repository
public interface MaintenanceRepository extends CrudRepository<MaintenanceIssue, Long >{

}
