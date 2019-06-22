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
public class FileBeatOutputSSLProperties {
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
