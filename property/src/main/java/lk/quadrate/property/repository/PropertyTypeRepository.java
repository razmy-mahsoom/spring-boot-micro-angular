package lk.quadrate.property.repository;

import lk.quadrate.property.entity.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {
    @Query("SELECT p FROM PropertyType p WHERE p.id=?1")
    Optional<PropertyType> findById(Long id);
    @Query("SELECT p FROM PropertyType p WHERE p.type=?1")
    Optional<PropertyType> findPropertyType(String type);
}
