package ru.basanov.publisher.itegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.web.client.RestTemplate;
import ru.basanov.publisher.dto.ActionMessage;

@MessageEndpoint
public class ActionMessageListener {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ServiceActivator(inputChannel = "actionMessageChannel")
    public void handler(final ActionMessage actionMessage) {
        restTemplate.postForLocation("http://localhost:8189/subscriber/api/message", actionMessage);
    }
}
