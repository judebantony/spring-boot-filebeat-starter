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
public class FileBeatOutputKafkaProperties {
	private boolean enabled;
	private List<String> hosts;
	private String topic;
	private FileBeatOutputPartitionHashProperties partition;
	private String key;
	private String username;
	private String password;
	private String version;
	private FileBeatOutputCodecJsonProperties codec;
	private Map<String, String> metadata;
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
