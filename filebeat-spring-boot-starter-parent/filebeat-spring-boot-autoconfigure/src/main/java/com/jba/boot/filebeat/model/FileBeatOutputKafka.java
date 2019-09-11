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
public class FileBeatOutputKafka {
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("hosts")
	private List<String> hosts;
	@JsonProperty("topic")
	private String topic;
	@JsonProperty("partition.round_robin")
	private FileBeatOutputPartitionHash partition;
	private String key;
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("version")
	private String version;
	@JsonProperty("codec")
	private FileBeatOutputCodecJson codec;
	@JsonProperty("metadata")
	private Map<String, String> metadata;
	@JsonProperty("worker")
	private Integer worker;
	@JsonProperty("bulk_max_size")
	private Integer bulkMaxSize;
	@JsonProperty("max_retries")
	private Integer maxRetries;
	@JsonProperty("timeout")
	private String timeout;
	@JsonProperty("broker_timeout")
	private String brokerTimeout;
	@JsonProperty("channel_buffer_size")
	private Integer channelBufferSize;
	@JsonProperty("keep_alive")
	private Integer keepAlive;
	@JsonProperty("compression")
	private String compression;
	@JsonProperty("compression_level")
	private Integer compressionLevel;
	@JsonProperty("max_message_bytes")
	private Long maxMessageBytes;
	@JsonProperty("required_acks")
	private Integer requiredAcks;
	@JsonProperty("client_id")
	private String clientId;
	@JsonProperty("ssl")
	private FileBeatOutputSSL ssl;

}
