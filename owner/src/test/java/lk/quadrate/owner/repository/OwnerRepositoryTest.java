package lk.quadrate.owner.repository;

import lk.quadrate.owner.entity.Gender;
import lk.quadrate.owner.entity.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;
    Owner ownerActual = null;
    @BeforeEach
    void setUp() {
        ownerActual =  Owner.builder()
                .userId("25d")
                .firstName("MOHAMED")
                .lastName("RAZMY")
                .dateOfBirth(LocalDateTime.now())
                .gender(Gender.Male)
                .governmentId("8699272068v")
                .city("KANDY")
                .country("Sri Lanka")
                .isProfileCompleted(true)
                .build();
        ownerRepository.save(ownerActual);
    }

    @AfterEach
    void tearDown() {
        ownerRepository.deleteAll();
    }

    @Test
    void findById() {
        Optional<Owner> owner = ownerRepository.findById(1L);
        assertThat(ownerActual).isEqualTo(owner.get());
    }

    @Test
    void findOwnerByUserId() {
        Optional<Owner> owner = ownerRepository.findOwnerByUserId("25d");
        assertThat(ownerActual).isEqualTo(owner.get());
    }
}