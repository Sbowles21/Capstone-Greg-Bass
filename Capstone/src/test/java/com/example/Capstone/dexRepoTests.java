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
public class dexRepoTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private dexRepo dexrepo;

    @Autowired
    private UserRepository userRepo;

    @Test
    public void testCreatedex() {
        User creator =  userRepo.findByUserId(8L);
        Pokedex dex = new Pokedex();
        dex.setDexname("default");
        dex.setCreator(creator);
        dex.setAccess("private");
    }
}
