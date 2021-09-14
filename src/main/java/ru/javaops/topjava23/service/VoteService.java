package ru.javaops.topjava23.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.topjava23.error.IllegalRequestDataException;
import ru.javaops.topjava23.model.Vote;
import ru.javaops.topjava23.repository.RestaurantRepository;
import ru.javaops.topjava23.repository.UserRepository;
import ru.javaops.topjava23.repository.VoteRepository;
import ru.javaops.topjava23.util.ClockUtil;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@AllArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    private final LocalTime votingTimeDeadline = LocalTime.of(11, 0);

    public void create(int userId, int restaurantId) {
        if (!isVoteTodayAlreadyDone(userId)) {
            Vote vote = new Vote(null, userRepository.getById(userId), restaurantRepository.getById(restaurantId),
                    LocalDate.now());
            voteRepository.save(vote);
        } else throw new IllegalRequestDataException("User " + userId + " already voted today " +
                "so the re-vote should be performed instead of new vote creation");
    }

    public void update(int userId, int restaurantId) {
        if (LocalTime.now(ClockUtil.clock).isBefore(votingTimeDeadline)) {
            Vote updated = voteRepository.checkPreviousVote(userId, LocalDate.now());
            updated.setRestaurant(restaurantRepository.getById(restaurantId));
            voteRepository.save(updated);
        } else throw new IllegalRequestDataException("User " + userId + " already voted today" +
                " so due it's already after past 11am, the re-vote cannot be performed");
    }

    public boolean isVoteTodayAlreadyDone(int userId) {
        return voteRepository.getByUserAndDate(userId, LocalDate.now()).isPresent();
    }
}
