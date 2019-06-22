/**
 * 
 */
package com.jba.boot.filebeat.autoconfigure;

import java.util.List;

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
public class FileBeatOutputKafkaProperties {
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
	private FileBeatOutputSSLProperties ssl;

}
