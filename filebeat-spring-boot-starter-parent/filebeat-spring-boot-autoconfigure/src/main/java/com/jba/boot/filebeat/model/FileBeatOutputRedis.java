/**
 * 
 */
package com.jba.boot.filebeat.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(Include.NON_NULL)
public class FileBeatOutputRedis {
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("hosts")
	private List<String> hosts;
	@JsonProperty("port")
	private String port;
	@JsonProperty("codec")
	private FileBeatOutputCodecJson codec;
	@JsonProperty("key")
	private String key;
	@JsonProperty("password")
	private String password;
	@JsonProperty("db")
	private Integer db;
	@JsonProperty("datatype")
	private String datatype;
	@JsonProperty("worker")
	private Integer worker;
	@JsonProperty("timeout")
	private String timeout;
	@JsonProperty("loadbalance")
	private boolean loadbalance;
	@JsonProperty("max_retries")
	private Integer maxRetries;
	@JsonProperty("bulk_max_size")
	private Integer bulkMaxSize;
	@JsonProperty("backoff")
	private Map<String, String> backoff;
	@JsonProperty("proxy_url")
	private String proxyUrl;
	@JsonProperty("proxy_use_local_resolver")
	private boolean proxyUseLocalResolver;
	@JsonProperty("ssl")
	private FileBeatOutputSSL ssl;

}
