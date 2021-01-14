package com.linkedin.learning.linkedinlearningfullstackangularspringboot.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Converter.ReservationEntityToReservationResponseConverter;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Converter.ReservationRequestToReservationEntityConverter;
import com.linkedin.learning.linkedinlearningfullstackangularspringboot.Converter.RoomEntityToReservableRoomResponse;

@Configuration
public class ConversionConfig {
	
	
		private Set<Converter> getConverters(){
			Set<Converter> converters = new HashSet<Converter>();
			converters.add(new RoomEntityToReservableRoomResponse());
			converters.add(new ReservationEntityToReservationResponseConverter());
			converters.add(new ReservationRequestToReservationEntityConverter());
			return converters;
		}
		
		@Bean
		public ConversionService conversionService() {
			ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
			bean.setConverters(getConverters());
			bean.afterPropertiesSet();
			
			return bean.getObject();
		}
}
