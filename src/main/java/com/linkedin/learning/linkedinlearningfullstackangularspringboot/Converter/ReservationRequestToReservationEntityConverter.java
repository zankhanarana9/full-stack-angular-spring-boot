package com.linkedin.learning.linkedinlearningfullstackangularspringboot.Converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Entity.ReservationEntity;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Model.Request.ReservationRequest;


@Component
public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest,ReservationEntity>  {

	@Override
	public ReservationEntity convert(ReservationRequest source) {
		// TODO Auto-generated method stub
		
		ReservationEntity reservationEntity = new ReservationEntity();
		reservationEntity.setCheckin(source.getCheckin());
		reservationEntity.setCheckout(source.getCheckout());
		
		if(null != source.getId()) {
			reservationEntity.setId(source.getId());
		}
		
		return reservationEntity;
	}
}
