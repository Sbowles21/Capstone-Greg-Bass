package com.example.Capstone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface Pokerepo extends JpaRepository<Pokemon, Long> {
    @Query("Select P from Pokemon P where P.Name = ?1")
    public Abilities findbyname(String Name);
}
