/**
 * 
 */
package com.jba.boot.filebeat.sampleapp.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jba.boot.filebeat.sampleapp.config.SampleAppConfigProperties;
import com.jba.boot.filebeat.sampleapp.service.api.SampleAppService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Jude
 *
 */
@Api(value = "Filebeat Starter Sample App APIs", consumes = "application/json")
@RestController
@RequestMapping("/api/v1/filebeat/sampleapp")
public class SampleAppController extends BaseSampleAppController {

	@Autowired
	private SampleAppConfigProperties configProperties;

	@Autowired
	private SampleAppService sampleAppService;

	@ApiOperation(value = "Health Check", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Health Check"),
			@ApiResponse(code = 401, message = "You are not authorized to view the Health Check"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Something went worng") })
	@GetMapping(value = "/healthcheck",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getHealthCheck()
			throws Exception {
		return sampleAppService.buildResponse(configProperties.getDesc());
	}

}
