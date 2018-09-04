package com.bo.converter;

import org.springframework.core.convert.converter.Converter;

public class StringTrimConverter implements Converter<String,String> {

	@Override
	public String convert(String str) {
		return str.trim();
	}

}
