package ru.javaops.topjava23.web.restaurant;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.javaops.topjava23.model.Restaurant;
import ru.javaops.topjava23.repository.RestaurantRepository;
import ru.javaops.topjava23.repository.VoteRepository;
import ru.javaops.topjava23.to.RestaurantTo;
import ru.javaops.topjava23.util.RestaurantUtil;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = ProfileRestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
@Tag(name = "Profile Restaurant Controller")
public class ProfileRestaurantController {

    static final String REST_URL = "/api/restaurants";

    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;

    @GetMapping
    public List<RestaurantTo> getAllWithTodaysMenu() {
        log.info("getAll for {}", LocalDate.now());
        List<Restaurant> restaurants = restaurantRepository.getAllWithMenuByDate(LocalDate.now());
        return RestaurantUtil.getTos(restaurants, voteRepository, LocalDate.now());
    }

    @GetMapping("/by-date")
    public List<RestaurantTo> getAllWithMenuByDate(@RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("getAll for {}", date);
        List<Restaurant> restaurants = restaurantRepository.getAllWithMenuByDate(date);
        return RestaurantUtil.getTos(restaurants, voteRepository, date);
    }
}