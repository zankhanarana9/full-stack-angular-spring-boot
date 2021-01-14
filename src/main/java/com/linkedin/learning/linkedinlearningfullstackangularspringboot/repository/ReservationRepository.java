package com.linkedin.learning.linkedinlearningfullstackangularspringboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

}
