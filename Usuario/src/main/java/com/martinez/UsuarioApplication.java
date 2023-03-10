package com.martinez;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.ResourceRetriever;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;

import java.net.URL;

@SpringBootApplication
public class UsuarioApplication {
	
	@Value("${com.tutorial.jwt.aws.connectionTimeout}")
	private int connectionTimeout;

	@Value("${com.tutorial.jwt.aws.readTimeout}")
	private int readTimeout;

	@Value("${com.tutorial.jwt.aws.jwkUrl}")
	private String jwkUrl;

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}
	
<<<<<<< HEAD
=======
	

>>>>>>> perfilEstudiante
	@Bean
	public ConfigurableJWTProcessor configurableJWTProcessor() throws MalformedURLException {
		ResourceRetriever resourceRetriever = new DefaultResourceRetriever(connectionTimeout, readTimeout);
		URL jwkURL = new URL(jwkUrl);
		JWKSource jwkSource = new RemoteJWKSet(jwkURL, resourceRetriever);
		ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
<<<<<<< HEAD
		JWSKeySelector keySelector = new JWSVerificationKeySelector(JWSAlgorithm.RS256, jwkSource);
		jwtProcessor.setJWSKeySelector(keySelector);
		return jwtProcessor;
	}
	
=======
		JWSKeySelector keySelector = new JWSVerificationKeySelector(JWSAlgorithm.RS256, jwkSource);	
		jwtProcessor.setJWSKeySelector(keySelector);
		return jwtProcessor;
	}
>>>>>>> perfilEstudiante

}
