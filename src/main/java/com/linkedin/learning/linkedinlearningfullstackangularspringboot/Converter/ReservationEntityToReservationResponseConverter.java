package com.linkedin.learning.linkedinlearningfullstackangularspringboot.Converter;

import org.springframework.core.convert.converter.Converter;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity.ReservationEntity;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Model.Response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter
		implements Converter<ReservationEntity, ReservationResponse> {

	@Override
	public ReservationResponse convert(ReservationEntity source) {
		// TODO Auto-generated method stub
		ReservationResponse reservationResponse = new ReservationResponse();

		reservationResponse.setCheckin(source.getCheckin());
		reservationResponse.setCheckout(source.getCheckout());
		 if (null != source.getRoomEntity())
	            reservationResponse.setId(source.getRoomEntity().getId());
		return reservationResponse;
	}

}
