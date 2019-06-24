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
public class FileBeatOutputRedis {
	private boolean enabled;
	private List<String> hosts;
	private String port;
	private boolean codecJsonPretty;
	private boolean codecJsonEscapeHtml;
	private String key;
	private String password;
	private Integer db;
	private String datatype;
	private Integer worker;
	private String timeout;
	private boolean loadbalance;
	private Integer maxRetries;
	private Integer bulkMaxSize;
	private Map<String, String> backoff;
	private String proxyUrl;
	private boolean proxyUseLocalResolver;
	private FileBeatOutputSSL ssl;

}
