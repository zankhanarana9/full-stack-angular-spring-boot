package com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

//import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Room")
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	private Integer roomNumber;

	@NonNull
	private String price;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<ReservationEntity> reservationEntityList;
	
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getPrice() {
		return price;
	}

	public List<ReservationEntity> getReservationEntityList() {
		return reservationEntityList;
	}

	public void setReservationEntityList(List<ReservationEntity> reservationEntityList) {
		this.reservationEntityList = reservationEntityList;
	}

	public void addReservationEntity(ReservationEntity reservationEntity) {
		if(null == reservationEntityList) {
			reservationEntityList = new ArrayList<>();
		}
		reservationEntityList.add(reservationEntity);
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public RoomEntity(Integer roomNumber, String price) {		
		this.roomNumber = roomNumber;
		this.price = price;
	}

	public RoomEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
