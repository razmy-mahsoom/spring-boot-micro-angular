package lk.quadrate.room.repository;

import lk.quadrate.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query("SELECT r FROM  Room r WHERE r.propertyId=?1")
    List<Room> findAllRoomByPropertyId(Long propertyId);
}
