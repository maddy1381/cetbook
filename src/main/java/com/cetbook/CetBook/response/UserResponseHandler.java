package com.cetbook.CetBook.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserResponseHandler {
	public static ResponseEntity<Object> userResponseBuilder(String message, HttpStatus httpStatus, Object user){
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		response.put("httpStatus", httpStatus);
		response.put("data", user);
		
		return new ResponseEntity<>(response, httpStatus);
	}
}
