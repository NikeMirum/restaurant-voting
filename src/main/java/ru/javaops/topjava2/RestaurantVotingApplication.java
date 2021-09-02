package ru.javaops.topjava2;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {
    private final RestaurantRepository restaurantRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantVotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(LocalDate.now());
        ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) restaurantRepository.getAllWithDish(LocalDate.now());
        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }
    }
}
