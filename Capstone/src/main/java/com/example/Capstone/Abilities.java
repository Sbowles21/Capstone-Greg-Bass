package com.example.Capstone;
import javax.persistence.*;

@Entity
@Table(name = "abilities")
public class Abilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="desc")
    private String desc;

    public Abilities(){}

    public Abilities(String name, String desc) {
        this.name = name;
        this.desc  = desc;
    }
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}