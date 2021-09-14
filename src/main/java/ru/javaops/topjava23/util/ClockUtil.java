package ru.javaops.topjava23.util;

import lombok.experimental.UtilityClass;

import java.time.*;

@UtilityClass
public class ClockUtil {
    public static Clock clock = Clock.fixed(Instant.ofEpochSecond(LocalDate.now().atStartOfDay()
            .toEpochSecond(ZoneOffset.UTC)), ZoneId.systemDefault());

    public static void useMockClock() {
        clock = Clock.fixed(Instant.ofEpochSecond(LocalDate.now().atStartOfDay()
                .toEpochSecond(ZoneOffset.UTC)), ZoneId.systemDefault());
    }

    public static void useDefaultClock() {
        clock = Clock.systemDefaultZone();
    }
}