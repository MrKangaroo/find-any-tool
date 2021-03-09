package com.find.any.cloud;

/**
 * Loadbalancer RestTemplate
 *
 * @author L.cm
 */
public class LbRestTemplate extends org.springframework.web.client.RestTemplate {

	public LbRestTemplate() {
		super();
	}

	public LbRestTemplate(org.springframework.http.client.ClientHttpRequestFactory requestFactory) {
		super(requestFactory);
	}

	public LbRestTemplate(java.util.List<org.springframework.http.converter.HttpMessageConverter<?>> messageConverters) {
		super(messageConverters);
	}
}
