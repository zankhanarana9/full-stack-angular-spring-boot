package com.linkedin.learning.linkedinlearningfullstackangularspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity.RoomEntity;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner {

	
	@Autowired
	RoomRepository roomRepository;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Bootstrapping data...");
		roomRepository.save(new RoomEntity(405,"200"));
		roomRepository.save(new RoomEntity(406,"250"));
		roomRepository.save(new RoomEntity(489,"250"));
		roomRepository.save(new RoomEntity(490,"270"));
		
		Iterable<RoomEntity> itr = roomRepository.findAll();
		
		System.out.println("Print data...");
		for(RoomEntity roomEntity: itr) {
			System.out.println(roomEntity.getId());
		}
	}

}
