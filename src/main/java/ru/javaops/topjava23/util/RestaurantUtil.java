package ru.javaops.topjava23.util;

import lombok.experimental.UtilityClass;
import ru.javaops.topjava23.model.Restaurant;
import ru.javaops.topjava23.model.Vote;
import ru.javaops.topjava23.to.RestaurantTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class RestaurantUtil {
    public static List<RestaurantTo> getTos(Collection<Restaurant> restaurants, List<Vote> votes) {
        return restaurants.stream().filter(Restaurant::isEnabled).map(r -> createTo(r, votes)).collect(Collectors.toList());
    }

    public static RestaurantTo createTo(Restaurant restaurant, List<Vote> votes) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getDishes(),
                (int) votes.stream().filter(v -> v.getRestaurant().getId() == restaurant.id()).count());
    }
}