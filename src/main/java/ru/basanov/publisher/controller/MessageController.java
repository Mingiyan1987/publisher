package ru.basanov.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.basanov.publisher.dto.ActionEnum;
import ru.basanov.publisher.dto.ActionMessage;
import ru.basanov.publisher.itegration.ActionMessageGateway;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class MessageController {

    private ActionMessageGateway actionMessageGateway;

    private static final RandomEnum<ActionEnum> r = new RandomEnum<ActionEnum>(ActionEnum.class);


    @Autowired
    public void setActionMessageGateway(ActionMessageGateway actionMessageGateway) {
        this.actionMessageGateway = actionMessageGateway;
    }

    @RequestMapping(value = "/action", method = RequestMethod.GET, produces = "application/json")
    public ActionMessage send() {
        ActionMessage actionMessage = new ActionMessage(r.random());
        actionMessageGateway.fire(
                MessageBuilder
                .withPayload(actionMessage)
                .build()
        );
        return actionMessage;
    }

    private static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> values) {
            this.values = values.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }
}
