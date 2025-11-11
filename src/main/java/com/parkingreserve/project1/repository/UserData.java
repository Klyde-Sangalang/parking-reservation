package com.parkingreserve.project1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkingreserve.project1.model.User;

@Repository
public interface UserData extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
