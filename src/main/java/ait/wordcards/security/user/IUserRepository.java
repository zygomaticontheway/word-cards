package ait.wordcards.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    public Optional<User> findUserByName(String name);
}
