package com.example.Capstone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface dexRepo extends JpaRepository<Pokedex, Long> {
    @Query("SELECT c FROM Pokedex c WHERE c.creator = ?1")
    public String findByCreatorId(Long id);
}