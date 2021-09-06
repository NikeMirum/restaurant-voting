package ru.javaops.topjava2.util;

import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.to.RestaurantTo;

public class RestaurantUtil {

    public static RestaurantTo createTo(Restaurant restaurant, Integer votesCount) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getDishes(), votesCount);
    }
}
