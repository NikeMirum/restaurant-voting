package ru.javaops.topjava2.web.restaurant;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.repository.RestaurantRepository;
import ru.javaops.topjava2.repository.VoteRepository;
import ru.javaops.topjava2.to.RestaurantTo;
import ru.javaops.topjava2.util.RestaurantUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = ProfileRestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class ProfileRestaurantController {

    static final String REST_URL = "/api/restaurants";

    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;

    @GetMapping
    public List<RestaurantTo> getAllRestaurantsWithTodaysMenu() {
        log.info("getAll for {}", LocalDate.now());
        List<Restaurant> restaurants = restaurantRepository.getAllWithMenuByDate(LocalDate.now());
        return RestaurantUtil.getTos(restaurants, voteRepository, LocalDate.now());
    }

    @GetMapping("/by-date")
    public List<RestaurantTo> getAllRestaurantsWithMenuByDate(@RequestParam @Nullable LocalDate date) {
        log.info("getAll for {}", date);
        List<Restaurant> restaurants = restaurantRepository.getAllWithMenuByDate(date);
        return RestaurantUtil.getTos(restaurants, voteRepository, date);
    }
}