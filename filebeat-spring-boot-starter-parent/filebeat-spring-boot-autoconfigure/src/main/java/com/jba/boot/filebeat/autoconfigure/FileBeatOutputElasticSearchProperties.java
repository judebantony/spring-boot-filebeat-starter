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
public class FileBeatOutputElasticSearchProperties {
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
	private FileBeatOutputSSLProperties ssl;
	private String proxyUrl;
	private boolean proxyUseLocalResolver;
	private Integer maxRetries;
	private Integer bulkMaxSize;
	private Map<String, String> backoff;
	private String timeout;

}
