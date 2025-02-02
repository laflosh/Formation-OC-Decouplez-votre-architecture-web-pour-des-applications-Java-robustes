package com.airbusiness.airbusiness_mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airbusiness.airbusiness_mvc.entities.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
