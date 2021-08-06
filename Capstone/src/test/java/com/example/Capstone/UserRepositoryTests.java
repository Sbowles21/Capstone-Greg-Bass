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
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private pokeRepo pokeRepo;

    @Test
    public void testCreateUser() {
        Set<Pokemon> poke_Set = new HashSet<>();

        Pokemon pokemon1 = pokeRepo.findMonById(9L);
        Pokemon pokemon2 = pokeRepo.findMonById(2L);
        Pokemon pokemon3 = pokeRepo.findMonById(8L);
        Pokemon pokemon4 = pokeRepo.findMonById(11L);

        poke_Set.add(pokemon1);
        poke_Set.add(pokemon2);
        poke_Set.add(pokemon3);
        poke_Set.add(pokemon4);


        User user = new User();
        user.setUserName("Testing Testston Testingson");
        user.setPassword("PasswordT");
        user.setCollabs(1L);
        user.setPokedex(2L);
        user.setPokemon(3L);
        user.setLikedPokemon(poke_Set);

        User saveUser = repository.save(user);

        User existUser = entityManager.find(User.class, saveUser.getId());

        assertThat(user.getUserName()).isEqualTo(existUser.getUserName());
    }
}
