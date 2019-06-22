/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import java.util.List;
import java.util.Map;

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
public class FileBeatOutputLogstashProperties {
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
	private FileBeatOutputSSLProperties ssl;
	private String proxyUrl;
	private boolean proxyUseLocalResolver;
	private Integer maxRetries;
	private Integer bulkMaxSize;
	private String timeout;
}
