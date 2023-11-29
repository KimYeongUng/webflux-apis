package com.example.webfluxapis.config;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import javax.net.ssl.SSLException;
import java.time.Duration;


@Configuration
public class WebClientConfig {
    WebClient webClient = create();

    @Bean(name = "webClient")
    public WebClient webClient(){
        return this.webClient;
    }

    private WebClient create() {
        HttpClient httpClient = HttpClient.create(ConnectionProvider
                .builder("apis")
                        .maxConnections(200)
                        .maxIdleTime(Duration.ofSeconds(10))
                        .pendingAcquireMaxCount(200)
                .build())
                .followRedirect(true)
                .secure(sslContextSpec -> {
                    try {
                        sslContextSpec.sslContext(SslContextBuilder.forClient().build())
                                .handshakeTimeout(Duration.ofSeconds(20))
                                .closeNotifyFlushTimeout(Duration.ofSeconds(20))
                                .closeNotifyReadTimeout(Duration.ofSeconds(20));
                    } catch (SSLException e) {
                        throw new RuntimeException(e);
                    }
                })
                .compress(true)
                .headers(headers-> headers.add(HttpHeaderNames.ACCEPT_ENCODING,"gzip,deflate,br"))
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(100));
                    connection.addHandlerLast(new WriteTimeoutHandler(100));
                })
                .responseTimeout(Duration.ofSeconds(100));

        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(config->config.defaultCodecs().maxInMemorySize(1024*1024*10))
                .build();


        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .exchangeStrategies(exchangeStrategies)
                .build();
    }

}
