package ru.javaops.topjava2.model;

import java.time.LocalDateTime;
import java.util.List;

public class Menu extends BaseEntity {

    private List<Dish> dishes;

    private LocalDateTime dateTime;
}
