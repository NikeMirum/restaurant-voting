package ru.javaops.topjava23.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava23.error.IllegalRequestDataException;
import ru.javaops.topjava23.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote> {

    @Query("SELECT v FROM Vote v WHERE v.date=:date")
    List<Vote> getByDate(LocalDate date);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=:date")
    Optional<Vote> getByUserAndDate(int userId, LocalDate date);

    default Vote checkPreviousVote(int userId, LocalDate date) {
        return getByUserAndDate(userId, date).orElseThrow(
                () -> new IllegalRequestDataException("User id = " + userId + " haven't made any vote at the day" + date));
    }
}