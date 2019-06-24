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
public class FileBeatOutputElasticSearch {
	private boolean enabled;
	private List<String> hosts;
	private String protocol;
	private String username;
	private String password;
	private Integer compressionLevel;
	private boolean escapeHtml;
	private Map<String, String> parameters;
	private Integer worker;
	private String index;
	private String pipeline;
	private String path;
	private Map<String, String> headers;
	private FileBeatOutputSSL ssl;
	private String proxyUrl;
	private boolean proxyUseLocalResolver;
	private Integer maxRetries;
	private Integer bulkMaxSize;
	private Map<String, String> backoff;
	private String timeout;

}
