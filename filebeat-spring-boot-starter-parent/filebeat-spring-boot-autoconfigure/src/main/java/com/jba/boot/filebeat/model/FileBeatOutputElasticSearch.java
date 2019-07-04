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
public class FileBeatOutputElasticSearch {
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("hosts")
	private List<String> hosts;
	@JsonProperty("protocol")
	private String protocol;
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("compression_level")
	private Integer compressionLevel;
	@JsonProperty("escape_html")
	private boolean escapeHtml;
	@JsonProperty("parameters")
	private Map<String, String> parameters;
	@JsonProperty("worker")
	private Integer worker;
	@JsonProperty("index")
	private String index;
	@JsonProperty("pipeline")
	private String pipeline;
	@JsonProperty("path")
	private String path;
	@JsonProperty("headers")
	private Map<String, String> headers;
	@JsonProperty("ssl")
	private FileBeatOutputSSL ssl;
	@JsonProperty("proxy_url")
	private String proxyUrl;
	@JsonProperty("max_retries")
	private Integer maxRetries;
	@JsonProperty("bulk_max_size")
	private Integer bulkMaxSize;
	@JsonProperty("backoff")
	private Map<String, String> backoff;
	@JsonProperty("timeout")
	private String timeout;

}
