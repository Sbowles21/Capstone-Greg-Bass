package com.example.Capstone;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Pokedex")
public class Pokedex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dexname;

    @ManyToOne
    @JoinColumn(name = "creator", nullable = false)
    private User creator;

    @ManyToMany
    @JoinTable(
            name = "dexes_in",
            joinColumns = @JoinColumn(name = "dex_id"),
            inverseJoinColumns = @JoinColumn(name = "poke_id")
    )
    Set<Pokemon> pokemon;
    @Column
    String access;

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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Set<Pokemon> getpokemon() {
        return pokemon;
    }

    public void setpokemon(Set<Pokemon> pokemon) {
        this.pokemon = pokemon;
    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
