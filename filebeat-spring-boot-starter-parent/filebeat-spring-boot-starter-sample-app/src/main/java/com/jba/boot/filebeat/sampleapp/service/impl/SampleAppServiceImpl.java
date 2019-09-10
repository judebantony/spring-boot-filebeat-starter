/**
 * 
 */
package com.jba.boot.filebeat.sampleapp.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jba.boot.filebeat.sampleapp.service.api.SampleAppService;

/**
 * @author Jude
 *
 */
@Service
public class SampleAppServiceImpl implements SampleAppService {



	@Override
	public ResponseEntity<?> buildResponse(String reponse) throws Exception {
		return new ResponseEntity<String>(reponse, HttpStatus.OK);

	}

}
