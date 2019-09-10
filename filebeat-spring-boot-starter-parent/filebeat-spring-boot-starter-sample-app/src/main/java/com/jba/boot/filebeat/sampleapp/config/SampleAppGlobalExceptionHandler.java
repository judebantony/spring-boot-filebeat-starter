/**
 * 
 */
package com.jba.boot.filebeat.sampleapp.config;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.jba.boot.filebeat.sampleapp.exception.SampleAppErrorDetails;

/**
 * @author Jude
 *
 */
@ControllerAdvice
public class SampleAppGlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		SampleAppErrorDetails errorDetails = new SampleAppErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
