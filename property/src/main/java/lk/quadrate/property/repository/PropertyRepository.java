package lk.quadrate.property.repository;

import lk.quadrate.property.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {


    @Query("SELECT p FROM Property p where p.ownerId =?1")
    List<Property> findAllByOwnerId(Long ownerId);
    @Query("SELECT p FROM Property p where p.ownerId =?1")
    Optional<Property> findByOwnerId(Long ownerId);
}
