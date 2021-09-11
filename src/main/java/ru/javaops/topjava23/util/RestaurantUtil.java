package ru.javaops.topjava23.util;

import lombok.experimental.UtilityClass;
import ru.javaops.topjava23.model.Restaurant;
import ru.javaops.topjava23.repository.VoteRepository;
import ru.javaops.topjava23.to.RestaurantTo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class RestaurantUtil {
    public static List<RestaurantTo> getTos(Collection<Restaurant> restaurants, VoteRepository voteRepository, LocalDate date) {
        return restaurants.stream().map(r -> createTo(r, voteRepository, date)).collect(Collectors.toList());
    }

    public static RestaurantTo createTo(Restaurant restaurant, VoteRepository voteRepository, LocalDate date) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getDishes(),
                voteRepository.getByRestaurantAndDate(restaurant.getId(), date).size());
    }
}