package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
public class NotImplementedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NotImplementedException(String message){
        super(message);
    } 
}
