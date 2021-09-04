package ru.javaops.topjava2.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class DateUtil {
    private static final LocalDate MIN_DATE = LocalDate.of(1, 1, 1);
    private static final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);

    public static LocalDate atCurrentDayOrChosen(LocalDate localDate) {
        return localDate != null ? localDate : MIN_DATE;
    }

    public static LocalDate atNextDayOrChosen(LocalDate localDate) {
        return localDate != null ? localDate.plus(1, ChronoUnit.DAYS) : MAX_DATE;
    }
}
