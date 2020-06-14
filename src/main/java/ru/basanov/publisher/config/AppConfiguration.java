package ru.basanov.publisher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.client.RestTemplate;

@EnableIntegration
@IntegrationComponentScan("ru.basanov.publisher.integration")
public class AppConfiguration {

    @Bean
    public MessageChannel actionMessageChannel() {
        return new DirectChannel();
    }
}
