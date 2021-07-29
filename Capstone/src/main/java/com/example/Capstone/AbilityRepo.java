package com.example.Capstone;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AbilityRepo extends JpaRepository<Abilities, Long> {

    @Query("SELECT a FROM Abilities a WHERE a.id = ?1")
    public Abilities findAbilityById(Long id);

}