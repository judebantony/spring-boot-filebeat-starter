/**
 * 
 */
package com.jba.boot.filebeat.model;

import java.util.List;

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
public class FileBeatOutputSSL {
	@JsonProperty("enabled")
	private boolean enabled;
	@JsonProperty("certificate_authorities")
	private List<String> certificateAuthorities;
	@JsonProperty("verification_mode")
	private String verificationMode;
	@JsonProperty("supported_protocols")
	private List<String> supportedProtocols;
	@JsonProperty("certificate")
	private String certificate;
	@JsonProperty("key")
	private String key;
	@JsonProperty("key_passphrase")
	private String keyPassphrase;
	@JsonProperty("cipher_suites")
	private List<String> cipherSuites;
	@JsonProperty("curve_types")
	private List<String> curveTypes;
	@JsonProperty("renegotiation")
	private String renegotiation;

}
