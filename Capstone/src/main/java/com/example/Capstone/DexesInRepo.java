package com.example.Capstone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DexesInRepo extends JpaRepository<Pokemon, Long>, CrudRepository<Pokemon, Long> {

    }
