package com.sha256.hashing.service;

import com.sha256.hashing.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {

    Optional<UserDetails> findByUsername(String username);
}
