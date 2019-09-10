/**
 * 
 */
package com.jba.boot.filebeat.sampleapp.service.api;

import org.springframework.http.ResponseEntity;

/**
 * @author Jude
 *
 */
public interface SampleAppService {

	ResponseEntity<?> buildResponse(String reponse) throws Exception;

}
