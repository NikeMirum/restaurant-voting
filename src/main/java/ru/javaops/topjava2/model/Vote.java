package ru.javaops.topjava2.model;

import java.time.LocalDateTime;

public class Vote extends BaseEntity{

    private User user;

    private Restaurant restaurant;

    private LocalDateTime dateTime;
}
