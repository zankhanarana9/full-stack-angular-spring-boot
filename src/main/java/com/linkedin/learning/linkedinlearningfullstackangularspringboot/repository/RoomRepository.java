package com.linkedin.learning.linkedinlearningfullstackangularspringboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long>{
	
	Optional<RoomEntity> findById(Long id);	
}
