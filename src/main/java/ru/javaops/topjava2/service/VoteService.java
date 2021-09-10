package ru.javaops.topjava2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.topjava2.error.IllegalRequestDataException;
import ru.javaops.topjava2.model.Restaurant;
import ru.javaops.topjava2.model.Vote;
import ru.javaops.topjava2.repository.RestaurantRepository;
import ru.javaops.topjava2.repository.UserRepository;
import ru.javaops.topjava2.repository.VoteRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@AllArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public Vote create(int userId, int restaurantId) {
        if (!isVoteTodayAlreadyDone(userId)){
            Vote vote = new Vote(null, userRepository.getById(userId), restaurantRepository.getById(restaurantId),
                    LocalDate.now());
            return voteRepository.save(vote);
        }
        else throw new IllegalRequestDataException("User " + userId + " already voted today" +
                "and the re-vote should be performed instead of new vote creation");
    }

    public void update(Vote vote, int restaurantId) {
        if (LocalTime.now().isBefore(LocalTime.of(23, 50))) {
            vote.setRestaurant(restaurantRepository.getById(restaurantId));
            voteRepository.save(vote);
        } else throw new IllegalRequestDataException("User " + vote.getUser().getName() + " already voted today" +
                "and due it's already after past 11am, the re-vote cannot be performed");
    }

    public boolean isVoteTodayAlreadyDone(int userId) {
        return voteRepository.getByUserAndDate(userId, LocalDate.now()).isPresent();
    }
}
