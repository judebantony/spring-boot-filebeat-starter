/**
 * 
 */
package com.jba.boot.filebeat.sampleapp.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Jude
 *
 */
public abstract class BaseContentController {
	public ResponseEntity<?> success() {
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
