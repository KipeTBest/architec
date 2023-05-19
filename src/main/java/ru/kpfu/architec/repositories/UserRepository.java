package ru.kpfu.architec.repositories;

import org.springframework.data.jpa.repository.Query;
import ru.kpfu.architec.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
