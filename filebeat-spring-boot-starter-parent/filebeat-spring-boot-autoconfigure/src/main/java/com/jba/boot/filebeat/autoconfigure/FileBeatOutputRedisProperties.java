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
public class FileBeatOutputRedisProperties {
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
	private FileBeatOutputSSLProperties ssl;

}
