package ru.javaops.topjava23.repository;

import org.springframework.transaction.annotation.Transactional;
import ru.javaops.topjava23.model.User;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends BaseRepository<User> {
    Optional<User> getByEmail(String email);
}