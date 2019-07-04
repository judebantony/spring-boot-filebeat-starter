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
public class FileBeatOutputLogstash {
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("hosts")
	private List<String> hosts;
	@JsonProperty("compression_level")
	private Integer compressionLevel;
	@JsonProperty("escape_html")
	private boolean escapeHtml;
	@JsonProperty("worker")
	private Integer worker;
	@JsonProperty("ttl")
	private String ttl;
	@JsonProperty("loadbalance")
	private boolean loadbalance;
	@JsonProperty("pipelining")
	private Integer pipelining;
	@JsonProperty("slow_start")
	private boolean slowStart;
	@JsonProperty("backoff")
	private Map<String, String> backoff;
	@JsonProperty("index")
	private String index;
	@JsonProperty("ssl")
	private FileBeatOutputSSL ssl;
	@JsonProperty("proxy_url")
	private String proxyUrl;
	@JsonProperty("proxy_use_local_resolver")
	private boolean proxyUseLocalResolver;
	@JsonProperty("max_retries")
	private Integer maxRetries;
	@JsonProperty("bulk_max_size")
	private Integer bulkMaxSize;
	@JsonProperty("timeout")
	private String timeout;
}
