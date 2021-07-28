package com.example.Capstone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface dexRepo extends JpaRepository<Pokedex, Long> {
}