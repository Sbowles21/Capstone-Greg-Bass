package com.example.Capstone;

import javax.persistence.*;
@Entity
@Table (name="Pokedex")
public class Pokedex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String dexname;
    @Column(nullable = false)
    private Long creator;
    @Column
    private Long pokeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDexname() {
        return dexname;
    }

    public void setDexname(String dexname) {
        this.dexname = dexname;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getPokeId() {
        return pokeId;
    }

    public void setPokeId(Long pokeId) {
        this.pokeId = pokeId;
    }

}
