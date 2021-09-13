package ru.javaops.topjava23.web.restaurant;

import ru.javaops.topjava23.model.Restaurant;
import ru.javaops.topjava23.to.RestaurantTo;
import ru.javaops.topjava23.web.MatcherFactory;

import static ru.javaops.topjava23.web.dish.DishTestHelper.*;

public class RestaurantTestHelper {
    public static final MatcherFactory.Matcher<Restaurant> MATCHER = MatcherFactory.
            usingIgnoringFieldsComparator(Restaurant.class, "dishes");
    public static final MatcherFactory.Matcher<Restaurant> WITH_DISHES_MATCHER = MatcherFactory.usingEqualsComparator(Restaurant.class);
    public static final MatcherFactory.Matcher<RestaurantTo> TO_MATCHER = MatcherFactory.usingEqualsComparator(RestaurantTo.class);

    public static final int RESTAURANT1_ID = 1;

    public static final Restaurant restaurant1 = new Restaurant(RESTAURANT1_ID, "McDonalds");
    public static final Restaurant restaurant2 = new Restaurant(RESTAURANT1_ID + 1, "KFC");
    public static final Restaurant restaurant3 = new Restaurant(RESTAURANT1_ID + 2, "Burger King");

    static {
        restaurant1.setDishes(restaurant1CurrentDate);
        restaurant2.setDishes(restaurant2CurrentDate);
        restaurant3.setDishes(restaurant3CurrentDate);
    }

    public static Restaurant getNew() {
        return new Restaurant(null, "New");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT1_ID, "UpdatedName");
    }
}