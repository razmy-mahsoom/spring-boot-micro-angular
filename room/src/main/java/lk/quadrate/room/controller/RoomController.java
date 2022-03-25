package lk.quadrate.room.controller;


import lk.quadrate.room.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/room")
public class RoomController {

    private final RoomService service;


}

