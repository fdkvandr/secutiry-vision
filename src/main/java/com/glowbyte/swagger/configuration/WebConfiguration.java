package com.glowbyte.swagger.configuration;


import com.glowbyte.swagger.service.SecurityVisionClient;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Configuration
public class WebConfiguration {

    @Bean
    public WebClient webClient(@Value("${sv-param.sv-token}") String svToken) throws SSLException {
        // Only for development. Disable SSL checks
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext));

        return WebClient.builder()
                .defaultHeader("sv-token", svToken)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Bean
    public SecurityVisionClient securityVisionClient(final WebClient webClient, final ConfigurableBeanFactory configurableBeanFactory) {
        WebClientAdapter webClientAdapter = WebClientAdapter.forClient(webClient);
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(webClientAdapter)
                .embeddedValueResolver(configurableBeanFactory::resolveEmbeddedValue)
                .build();

        return httpServiceProxyFactory.createClient(SecurityVisionClient.class);
    }
}
