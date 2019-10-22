package se.cryptosnack.demo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateFormatService {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public String getDateTimeSent(LocalDateTime localDateTime) {
        return new String(localDateTime.format(dateTimeFormatter));
    }
}
