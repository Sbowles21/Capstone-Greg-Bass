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

    @ManyToOne
    @JoinColumn(name="creator", nullable = false)
    private User creator;

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

}
