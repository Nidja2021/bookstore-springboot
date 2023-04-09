package com.springsecurityjwt.springsecurityjwt.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserReposity extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);
}
