/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jude
 *
 */
@Data
@ToString
@Validated
public class FileBeatOutputPartitionHashProperties {
	private boolean reachableOnly;
	private List<String> hash;
}
