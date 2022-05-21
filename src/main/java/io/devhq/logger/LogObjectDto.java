package io.devhq.logger;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;


@Getter
@Setter
public class LogObjectDto {
    private String message;
    private Pair[] attributes;
    private ZonedDateTime date;

}
