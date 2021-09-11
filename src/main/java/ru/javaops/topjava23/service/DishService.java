package ru.javaops.topjava23.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.topjava23.model.Dish;
import ru.javaops.topjava23.repository.DishRepository;
import ru.javaops.topjava23.repository.RestaurantRepository;

@Service
@AllArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public Dish save(Dish dish, int restaurantId) {
        dish.setRestaurant(restaurantRepository.getById(restaurantId));
        return dishRepository.save(dish);
    }
}