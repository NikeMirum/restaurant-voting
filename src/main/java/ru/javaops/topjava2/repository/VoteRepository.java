package ru.javaops.topjava2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava2.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote>{

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=:date")
    Optional<Vote> getByUserAndDate(int userId, LocalDate date);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:restaurantId AND v.date=:date")
    List<Vote> getByRestaurantAndDate(int restaurantId, LocalDate date);
}