package ru.javaops.topjava2.web.restaurant;

import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.web.MatcherFactory;

public class RestaurantTestData {
    public static final MatcherFactory.Matcher<Restaurant> MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Restaurant.class, "dishes");

    public static final int RESTAURANT1_ID = 1;
    public static final int NOT_FOUND = 100;

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT1_ID, "McDonalds");
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT1_ID + 1, "KFC");
    public static final Restaurant restaurant3 = new Restaurant(RESTAURANT1_ID + 2, "Burger King");
    public static final Restaurant restaurant4 = new Restaurant(RESTAURANT1_ID + 3, "Subway");
    public static final Restaurant restaurant5 = new Restaurant(RESTAURANT1_ID + 4, "Pizza Hut");

    public static Restaurant getNew() {
        return new Restaurant(null, "New");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1_ID, "UpdatedName");
    }
}