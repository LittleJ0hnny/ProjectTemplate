package com.littlejohnny.utills;

import java.time.LocalDateTime;
import java.util.TimeZone;

public class DateTimeUtil {

    /**
     * This method always returns current time localized with "Europe/Kiev" timezone.
     * @return {@link LocalDateTime} instance with current time.
     */
    public static LocalDateTime currentTime() {
        return LocalDateTime.now(TimeZone.getTimeZone("Europe/Kiev").toZoneId());
    }

}
