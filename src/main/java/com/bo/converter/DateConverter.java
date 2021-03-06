package com.bo.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class DateConverter implements Converter<String,Date> {

	public Date convert(String info) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(info);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
