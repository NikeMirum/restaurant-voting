package ru.javaops.topjava2;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.repository.RestaurantRepository;
import ru.javaops.topjava2.repository.VoteRepository;
import ru.javaops.topjava2.to.RestaurantTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {
    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(LocalDate.now());
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantRepository.getAllWithMenuByDate(LocalDate.now());
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
        ArrayList<RestaurantTo> restaurantTos = (ArrayList<RestaurantTo>) restaurants.stream()
                .map(r -> new RestaurantTo(r.getId(), r.getName(), r.getDishes(), voteRepository.getByRestaurantAndDate(r.getId(), LocalDate.now()).size()))
                .collect(Collectors.toList());
        for (RestaurantTo restaurant : restaurantTos) {
            System.out.println(restaurant);
        }
    }
}
