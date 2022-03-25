package lk.quadrate.clients.owner.room;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "room")
public interface RoomClient {

    @PostMapping(path = "api/v1/room")
    RoomClientResponse saveRoom(@Validated @RequestBody RoomRequestModel roomRequestModel);
}
