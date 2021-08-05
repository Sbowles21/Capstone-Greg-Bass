package com.example.Capstone;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class dexRepoTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private dexRepo dexrepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private pokeRepo pokeRepo;
    @Test
    public void testCreatedex() {

        Set<Pokemon> pokeman = new HashSet<>();

        Pokemon pokemon1 = pokeRepo.findMonById(1L);
        Pokemon pokemon2 = pokeRepo.findMonById(2L);
        Pokemon pokemon3 = pokeRepo.findMonById(4L);
        Pokemon pokemon4 = pokeRepo.findMonById(8L);

        pokeman.add(pokemon1);
        pokeman.add(pokemon2);
        pokeman.add(pokemon3);
        pokeman.add(pokemon4);


        User creator =  userRepo.findByUserId(8L);
        Pokedex dex = new Pokedex();
        dex.setDexname("default");
        dex.setCreator(creator);
        dex.setpokemon(pokeman);


        dex.setAccess("private");
    }
}
