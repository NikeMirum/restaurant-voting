package ru.javaops.topjava2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava2.model.Dish;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DishRepository extends BaseRepository<Dish> {

    @Query("SELECT d FROM Dish d WHERE d.id = :id")
    Optional<Dish> get(int id);

    @Query("SELECT d FROM Dish d WHERE d.date=:date ORDER BY d.restaurant.id DESC")
    List<Dish> getAllByDate(int date);

    @Query("SELECT d FROM Dish d WHERE d.date=:CURRENTDATE ORDER BY d.restaurant.id DESC")
    List<Dish> getAllByCurrentDate();

    @Query("SELECT d FROM Dish d WHERE d.date=:date AND d.restaurant.id=:restaurantId ORDER BY d.restaurant.id DESC")
    List<Dish> getAllByDateAndRestaurant(int date, int restaurantId);

    @Query("SELECT d FROM Dish d WHERE d.date=:CURRENTDATE AND d.restaurant.id=:restaurantId ORDER BY d.restaurant.id DESC")
    List<Dish> getAllByCurrentDateAndRestaurant(int restaurantId);

}
