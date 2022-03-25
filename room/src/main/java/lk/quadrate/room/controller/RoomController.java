package lk.quadrate.room.controller;

import lk.quadrate.clients.owner.room.RoomClientResponse;
import lk.quadrate.clients.owner.room.RoomRequestModel;
import lk.quadrate.room.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/room")
public class RoomController {

    private final RoomService service;

    @PostMapping(path = "api/v1/room")
    RoomClientResponse saveRoom(@Validated @RequestBody RoomRequestModel roomRequestModel){
        service.saveRoom(roomRequestModel)
    }
}
