package com.example.Capstone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface dexRepo extends JpaRepository<Pokedex, Long> {
    @Query("SELECT c FROM Pokedex c WHERE c.creator = ?1")
    public String findByCreatorId(Long id);

    @Query("SELECT d FROM Pokedex d WHERE d.id = ?1 AND access= 'public'")
    public User findPublicDex(Long id);

}