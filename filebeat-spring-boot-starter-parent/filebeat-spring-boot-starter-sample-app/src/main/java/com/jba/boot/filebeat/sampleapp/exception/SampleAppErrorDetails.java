/**
 * 
 */
package com.jba.boot.filebeat.sampleapp.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jude
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleAppErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
}
