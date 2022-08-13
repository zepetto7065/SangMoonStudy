package me.zepetto.demospringmvc;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Event {

    private String name;

    private int limitOfEnrollement;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
}
