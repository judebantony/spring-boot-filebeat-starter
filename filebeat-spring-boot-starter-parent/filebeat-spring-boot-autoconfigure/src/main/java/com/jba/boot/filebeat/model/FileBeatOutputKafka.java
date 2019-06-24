/**
 * 
 */
package com.jba.boot.filebeat.model;

import java.util.List;

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
public class FileBeatOutputKafka {
	private boolean enabled;
	private List<String> hosts;
	private String topic;
	private boolean partitionRoundRobinReachableOnly;
	private String key;
	private boolean partitionHashReachableOnly;
	private List<String> partitionHash;
	private String username;
	private String password;
	private String version;
	private boolean codecJsonPretty;
	private boolean codecJsonEscapeHtml;
	private Integer metadataRetryMax;
	private String metadataRetryBackoff;
	private String metadataRefreshFrequency;
	private Integer worker;
	private Integer bulkMaxSize;
	private Integer maxRetries;
	private String timeout;
	private String brokerTimeout;
	private Integer channelBufferSize;
	private Integer keepAlive;
	private String compression;
	private Integer compressionLevel;
	private Long maxMessageBytes;
	private Integer requiredAcks;
	private String clientId;
	private FileBeatOutputSSL ssl;

}
