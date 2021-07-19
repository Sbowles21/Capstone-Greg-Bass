package com.example.Capstone;

import javax.persistence.*;

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
}
