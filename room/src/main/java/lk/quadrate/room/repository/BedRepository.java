package lk.quadrate.room.repository;

import lk.quadrate.room.entity.Bed;
import lk.quadrate.room.entity.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed,Long> {

    @Query("SELECT b FROM BedType b")
    List<BedType> findAllBedTypes();
    @Query("SELECT b from BedType b WHERE b.type=?1")
    BedType findBedTypeByName(String name);

    @Query("SELECT b FROM Bed b WHERE b.room=?1")
    List<Bed> findAllBedByRoomId(Long roomId);
}
