package com.example.TarefaDoCaverna.Exception.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.TarefaDoCaverna.Exception.CaralhoException;


@RestControllerAdvice
public class CaralhoHandler {
	
	@ExceptionHandler(value = CaralhoException.class)	
	public ResponseEntity<Object> exception(CaralhoException exception) {
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("ERRO NO BULE DE CHÁ");
	}
}
