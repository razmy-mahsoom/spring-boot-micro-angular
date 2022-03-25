package lk.quadrate.owner.repository;

import lk.quadrate.owner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    @Query("SELECT o FROM Owner o WHERE o.id=?1")
    Optional<Owner> findById(Long ownerId);
    @Query("SELECT o FROM Owner o WHERE o.userId=?1")
    Optional<Owner> findOwnerByUserId(String userId);
}
