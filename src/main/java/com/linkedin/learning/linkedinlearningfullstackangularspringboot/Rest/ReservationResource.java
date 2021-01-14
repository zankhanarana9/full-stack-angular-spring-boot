package com.linkedin.learning.linkedinlearningfullstackangularspringboot.Rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Converter.RoomEntityToReservableRoomResponse;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity.ReservationEntity;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity.RoomEntity;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Model.Request.ReservationRequest;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Model.Response.ReservationResponse;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Model.Response.ReservableRoomResponse;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.repository.PageableRoomRepository;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.repository.ReservationRepository;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.repository.RoomRepository;

@RestController
//Controller + REquestBody
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
@CrossOrigin
public class ReservationResource {

	@Autowired
	PageableRoomRepository pageableRoomRepository;

	@Autowired
	private RoomEntityToReservableRoomResponse converter = new RoomEntityToReservableRoomResponse();

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	ConversionService conversionService;

	@SuppressWarnings("deprecation")
	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRooms(
			@RequestParam(value = "checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
			@RequestParam(value = "checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
			Pageable pageable) {

		Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
		return roomEntityList.map(converter::convert);

	}

	@SuppressWarnings("deprecation")
	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId) {

		RoomEntity roomEntity = roomRepository.findById(roomId).get();
		return new ResponseEntity<>(roomEntity, HttpStatus.OK);
	}
	// Post end point

	@SuppressWarnings("deprecation")
	@RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {

		System.out.print(reservationRequest.getRoomId() + " " + reservationRequest.getCheckin() + " "
				+ reservationRequest.getCheckout());
		ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);
		reservationRepository.save(reservationEntity);

		RoomEntity roomEntity = roomRepository.findById(reservationRequest.getRoomId()).get();
		roomEntity.addReservationEntity(reservationEntity);
		roomRepository.save(roomEntity);
		reservationEntity.setRoomEntity(roomEntity);

		ReservationResponse reservationResponse = conversionService.convert(reservationEntity,
				ReservationResponse.class);
		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(path = "", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservableRoomResponse> updateReservation(
			@RequestBody ReservationRequest reservationRequest) {
		return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);

	}

	@RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
