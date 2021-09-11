package ru.javaops.topjava23.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava23.error.IllegalRequestDataException;
import ru.javaops.topjava23.model.Dish;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DishRepository extends BaseRepository<Dish> {

    @Query("SELECT d FROM Dish d WHERE d.id=:id and d.restaurant.id=:restaurantId")
    Optional<Dish> get(int id, int restaurantId);

    @Query("SELECT d FROM Dish d WHERE d.date=:date AND d.restaurant.id=:restaurantId ORDER BY d.restaurant.id DESC")
    List<Dish> getAllByRestaurantAndDate(int restaurantId, LocalDate date);

    default Dish checkBelong(int id, int restaurantId) {
        return get(id, restaurantId).orElseThrow(
                () -> new IllegalRequestDataException("Dish id=" + id + " doesn't belong to Restaurant id=" + restaurantId));
    }
}
