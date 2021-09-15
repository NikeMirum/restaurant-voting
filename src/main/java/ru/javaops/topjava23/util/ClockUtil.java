package ru.javaops.topjava23.util;

import lombok.experimental.UtilityClass;

import java.time.*;

@UtilityClass
public class ClockUtil {
    public static Clock clock = Clock.systemDefaultZone();

    public static void useMockClock() {
        clock = Clock.fixed((LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))
                .toInstant(OffsetDateTime.now().getOffset())), Clock.systemDefaultZone().getZone());
    }

    public static void useDefaultClock() {
        clock = Clock.systemDefaultZone();
    }
}