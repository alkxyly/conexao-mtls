package com.mtls.cliente.mtlscliente.config;

import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.springframework.core.io.Resource;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.*;

import javax.net.ssl.SSLContext;

@Configuration
public class RestClientConfig {
    @Value("${client.ssl.trust-store}")
    private Resource trustStore;
    @Value("${client.ssl.key-store}")
    private Resource keyStore;
    @Value("${client.ssl.trust-store-password}")
    private String trustStorePassword;
    @Value("${client.ssl.key-store-password}")
    private String keyStorePassword;

    @Bean
    public RestTemplate restTemplate() throws Exception {
        // Set up SSL context with truststore and keystore
        SSLContext sslContext = new SSLContextBuilder()
                .loadKeyMaterial(
                        keyStore.getURL(),
                        keyStorePassword.toCharArray(),
                        keyStorePassword.toCharArray()
                )
                .loadTrustMaterial(
                        trustStore.getURL(),
                        trustStorePassword.toCharArray()
                )
                .build();

        // Configure the SSLConnectionSocketFactory to use NoopHostnameVerifier
        SSLConnectionSocketFactory sslConFactory = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());

        // Use a connection manager with the SSL socket factory
        var cm = PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(sslConFactory)
                .build();

        // Build the CloseableHttpClient and set the connection manager
        var httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();

        // Set the HttpClient as the request factory for the RestTemplate
        var requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplate(requestFactory);
    }
}
