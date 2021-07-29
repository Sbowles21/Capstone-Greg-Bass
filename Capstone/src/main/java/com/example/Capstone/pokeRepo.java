package com.example.Capstone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface pokeRepo extends JpaRepository<Pokemon, Long>{
    @Query("SELECT p FROM Pokemon p where p.creator = ?1")
    public List<Pokemon> findMonByUserId(Long id);

    @Query("SELECT p FROM Pokemon p where p.id = ?1")
    public Pokemon findMonById(Long id);


}
