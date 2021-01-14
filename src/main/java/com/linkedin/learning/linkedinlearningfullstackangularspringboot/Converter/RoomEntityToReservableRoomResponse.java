package com.linkedin.learning.linkedinlearningfullstackangularspringboot.Converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity.RoomEntity;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Model.Links;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Model.Self;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Model.Response.ReservableRoomResponse;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Rest.ResourceConstants;

@Component
public class RoomEntityToReservableRoomResponse implements Converter<RoomEntity, ReservableRoomResponse> {

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		// TODO Auto-generated method stub

		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		
		if(null != source.getId()) {
			reservationResponse.setId(source.getId());
		}
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);

		reservationResponse.setLinks(links);

		return reservationResponse;
	}

}