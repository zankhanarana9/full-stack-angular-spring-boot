package com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Reservation")
public class ReservationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	private LocalDate checkin;

	@NonNull
	private LocalDate checkout;

	@ManyToOne
	private RoomEntity roomEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}

	public void setCheckout(LocalDate checkout) {
		this.checkout = checkout;
	}

	public ReservationEntity(LocalDate checkin, LocalDate checkout, RoomEntity roomEntity) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
		this.roomEntity = roomEntity;
	}

	public ReservationEntity() {
		super();
	}

	public RoomEntity getRoomEntity() {
		return roomEntity;
	}

	public void setRoomEntity(RoomEntity roomEntity) {
		this.roomEntity = roomEntity;
	}

}
