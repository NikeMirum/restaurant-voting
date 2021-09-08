package ru.javaops.topjava2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.topjava2.error.IllegalRequestDataException;
import ru.javaops.topjava2.model.Vote;
import ru.javaops.topjava2.repository.UserRepository;
import ru.javaops.topjava2.repository.VoteRepository;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;
    private final UserRepository userRepository;

    public Vote save(Vote vote, int userId) {
        vote.setUser(userRepository.getById(userId));
        return voteRepository.save(vote);
    }

    public void update(Vote vote, int userId) {
        if (LocalTime.now().isBefore(LocalTime.of(11, 0))) {
            vote.setUser(userRepository.getById(userId));
            voteRepository.save(vote);
        } else throw new IllegalRequestDataException("User " + vote.getUser().getName() + " already voted today" +
                "and due it's already after past 11am, the re-vote cannot be performed");
    }

//    boolean isVoteTodayAlreadyDone(int userId){
//        return voteRepository.getByUserAndCurrentDate(userId, LocalDate.now()).isPresent();
//    }
}
