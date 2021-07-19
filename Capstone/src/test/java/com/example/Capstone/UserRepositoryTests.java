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
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUserName("Testing Testingson");
        user.setPassword("Password");
        user.setCollabs(1L);
        user.setPokedex(2L);
        user.setPokemon(3L);

        User saveUser = repository.save(user);

        User existUser = entityManager.find(User.class, saveUser.getId());

        assertThat(user.getUserName()).isEqualTo(existUser.getUserName());
    }
}
