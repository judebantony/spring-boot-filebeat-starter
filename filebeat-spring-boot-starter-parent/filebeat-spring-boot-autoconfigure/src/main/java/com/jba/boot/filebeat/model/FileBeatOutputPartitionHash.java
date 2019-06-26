/**
 * 
 */
package com.jba.boot.filebeat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jude
 *
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class FileBeatOutputPartitionHash {
	@JsonProperty("reachable_only")
	private boolean reachableOnly;
	@JsonProperty("hash")
	private List<String> hash;
}
