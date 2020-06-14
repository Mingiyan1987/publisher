package ru.basanov.publisher.itegration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import ru.basanov.publisher.dto.ActionMessage;

@MessagingGateway(name = "actionMessageGateway",
                    defaultRequestChannel = "actionMessageChannel"
)
public interface ActionMessageGateway {

    @Gateway
    void fire(Message<ActionMessage> message);
}
