package lk.quadrate.room.service;

import lk.quadrate.room.entity.Room;
import lk.quadrate.room.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoomService {

    private final RoomRepository repository;

    public List<Room> getAllRoomsForProperty(Long propertyId){
        return repository.findAllRoomByPropertyId(propertyId);
    }

    public Room saveRoom(Room room){
        return repository.save(room);
    }
}
