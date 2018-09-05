package com.ks.masapi.util;

import java.io.Reader;
import java.io.StringReader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ks.masapi.model.InterestRate;

/**
 * Json helper to cast the json string into object
 *
 */
public class JsonHelper {
	public JsonHelper(){
		
	}
	
	public InterestRate convert(String input) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();				
		Reader reader = new StringReader(input);	
		InterestRate interestRate = objectMapper.readValue(reader, InterestRate.class);
		return interestRate;
	}
}
