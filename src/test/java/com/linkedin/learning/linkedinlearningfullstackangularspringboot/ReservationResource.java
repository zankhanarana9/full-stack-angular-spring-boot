package com.linkedin.learning.linkedinlearningfullstackangularspringboot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Rest.ResourceConstants;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LinkedInLearningFullStackAngularSpringBootApplication.class,
webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReservationResource {
	
	@LocalServerPort
	private int port;
	

	@BeforeEach
	void setUp() throws Exception {
		
		RestAssured.port = Integer.valueOf(port);
		RestAssured.basePath = ResourceConstants.ROOM_RESERVATION_V1;
		RestAssured.baseURI = "http://localhost";
	}

	@Test
	void test() {	
		given().when().get("/" + "1").then()
			.statusCode(200);
	}

}
