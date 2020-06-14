package ru.basanov.publisher.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Random;

@Getter
@Setter
public class ActionMessage implements Serializable {

    private Long msisdn;

    private ActionEnum actionEnum;

    private Long timestamp;

    public ActionMessage(ActionEnum actionEnum) {
        this.msisdn = new Random().nextLong();
        this.actionEnum = actionEnum;
        this.timestamp = Instant.now().getEpochSecond();
    }


}
