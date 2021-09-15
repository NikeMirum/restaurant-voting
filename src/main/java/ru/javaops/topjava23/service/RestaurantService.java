package ru.javaops.topjava23.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.topjava23.model.Restaurant;
import ru.javaops.topjava23.model.Vote;
import ru.javaops.topjava23.repository.RestaurantRepository;
import ru.javaops.topjava23.repository.VoteRepository;
import ru.javaops.topjava23.to.RestaurantTo;
import ru.javaops.topjava23.util.RestaurantUtil;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;

    public List<RestaurantTo> getAllWithTodaysMenu() {
        List<Restaurant> restaurants = restaurantRepository.getAllWithMenuByDate(LocalDate.now());
        List<Vote> votes = voteRepository.getByDate(LocalDate.now());
        return RestaurantUtil.getTos(restaurants, votes);
    }

    public List<RestaurantTo> getAllWithMenuByDate(LocalDate date) {
        List<Restaurant> restaurants = restaurantRepository.getAllWithMenuByDate(date);
        List<Vote> votes = voteRepository.getByDate(date);
        return RestaurantUtil.getTos(restaurants, votes);
    }
}