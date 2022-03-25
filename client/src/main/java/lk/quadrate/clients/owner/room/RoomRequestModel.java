package lk.quadrate.clients.owner.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoomRequestModel {

    private String roomName;
    private String roomCustomName;
    private Integer size;
    private Measurement measurement;
    private Long propertyId;
    private String imageUrl;
    private Double pricePerNight;
    private Integer numberOfPeopleCanAccommodate;
    private LocalDateTime createdAt;
}
