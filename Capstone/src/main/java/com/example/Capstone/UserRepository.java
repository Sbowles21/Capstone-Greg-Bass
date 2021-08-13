package com.example.Capstone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findByUsername(String username);

    @Query("SELECT i from User i where i.id=?1")
    public User findByUserId(Long Id);

    @Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findByUsernameNoIn();
}
