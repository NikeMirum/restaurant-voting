package ru.javaops.topjava2.util;

import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.to.RestaurantTo;
import ru.javaops.topjava2.to.RestaurantWithVotesTo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class RestaurantUtil {

    public static List<RestaurantTo> getTosByDate(Collection<Restaurant> restaurants, LocalDate date) {
        return null;
    }

    public static List<RestaurantWithVotesTo> getTosByDateWithVoteCount(Collection<Restaurant> restaurants) {
        return null;
    }

//    public static RestaurantTo createTo(Restaurant restaurant, LocalDate date, int votesCount){
//        return new RestaurantTo();
//    }
//
//    public static RestaurantTo createTo(Restaurant restaurant, LocalDate date, int votesCount){
//        List<Vote> restaurantVotes = getByRestaurantAndDate(restaurant.getId(),date)
//        int voteCount =
//    }
}
