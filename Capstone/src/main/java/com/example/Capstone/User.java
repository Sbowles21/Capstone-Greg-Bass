package com.example.Capstone;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    private String userName;

    @Column(nullable = false, length = 64)
    private String password;

    @Column
    private Long pokedex;

    @Column
    private Long pokemon;

    @Column
    private Long collabs;

    @ManyToMany
    @JoinTable (
        name = "liked_pokemon",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "poke_id")
    )
    Set<Pokemon> likedPokemon;

    public Long getPokedex() {
        return pokedex;
    }

    public void setPokedex(Long pokedex) {
        this.pokedex = pokedex;
    }

    public Long getPokemon() {
        return pokemon;
    }

    public void setPokemon(Long pokemon) {
        this.pokemon = pokemon;
    }

    public Long getCollabs() {
        return collabs;
    }

    public void setCollabs(Long collabs) {
        this.collabs = collabs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Pokemon> getLikedPokemon() {
        return likedPokemon;
    }

    public void setLikedPokemon(Set<Pokemon> likedPokemon) {
        this.likedPokemon = likedPokemon;
    }

}
