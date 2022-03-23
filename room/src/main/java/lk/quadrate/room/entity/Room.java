package lk.quadrate.room.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomName;
    private String roomCustomName;
    private Integer size;
    @Enumerated(EnumType.STRING)
    private Measurement measurement;
    private Long propertyId;
    private String imageUrl;
    private Double pricePerNight;
    private Integer numberOfPeopleCanAccommodate;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER,mappedBy = "room")
    private List<Bed> beds = new ArrayList<>();
    private LocalDateTime createdAt;

    public void addBed(Bed bed){
        if(!beds.contains(bed)){
            bed.setRoom(this);
            beds.add(bed);
        }
    }

    public void removeBed(Bed bed){
        if(beds.contains(bed)){
            bed.setRoom(null);
            beds.remove(bed);
        }
    }

}
