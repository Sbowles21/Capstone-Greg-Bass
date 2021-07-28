package com.example.Capstone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class pokeRepoTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private pokeRepo pokerepo;

    @Test
    public void testCreatePokemon() {
        Pokemon poke = new Pokemon();
        poke.setName("Default");
        poke.setEntry("Default");
        poke.setHeight("0");
        poke.setWeight("0");
        poke.setGender("Male");
        poke.setCategory("Default");
        poke.setTypes("Fire");
        poke.setAbility(1);
        poke.setWeaknesses("Water");
        poke.setEvolutions("Default");
        poke.setEvo_Lvl(0);


        Pokemon savedPokemon = pokerepo.save(poke);

        Pokemon existPokemon = entityManager.find(Pokemon.class, savedPokemon.getId());

        assertThat(poke.getName()).isEqualTo(existPokemon.getName());
    }
}
