/**
 * 
 */
package com.jba.boot.filebeat.utils;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.jba.boot.filebeat.model.FileBeatConfig;

/**
 * @author Jude
 *
 */
@Component
@Validated
public class FileBeatConfigValidator {

	public boolean validateFileBeatConfig(@Valid FileBeatConfig fileBeatConfig) {
		// TODO:: do something
		return true;
	}
}
