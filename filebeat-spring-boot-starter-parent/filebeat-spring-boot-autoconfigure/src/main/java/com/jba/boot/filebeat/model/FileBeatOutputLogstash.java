/**
 * 
 */
package com.jba.boot.filebeat.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

/**
 * @author Jude
 *
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class FileBeatOutputLogstash {
	private boolean enabled;
	private List<String> hosts;
	private Integer compressionLevel;
	private boolean escapeHtml;
	private Integer worker;
	private String ttl;
	private boolean loadbalance;
	private Integer pipelining;
	private boolean slowStart;
	private Map<String, String> backoff;
	private String index;
	private FileBeatOutputSSL ssl;
	private String proxyUrl;
	private boolean proxyUseLocalResolver;
	private Integer maxRetries;
	private Integer bulkMaxSize;
	private String timeout;
}
