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
public class FileBeatOutputSSL {
	private boolean enabled;
	private List<String> certificateAuthorities;
	private String verificationMode;
	private List<String> supportedProtocols;
	private String certificate;
	private String key;
	private String keyPassphrase;
	private List<String> cipherSuites;
	private List<String> curveTypes;
	private String renegotiation;

}
