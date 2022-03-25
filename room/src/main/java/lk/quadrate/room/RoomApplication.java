package lk.quadrate.room;

import lk.quadrate.room.entity.Bed;
import lk.quadrate.room.entity.BedType;
import lk.quadrate.room.entity.Measurement;
import lk.quadrate.room.entity.Room;
import lk.quadrate.room.repository.BedRepository;
import lk.quadrate.room.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableEurekaClient

@Slf4j
public class RoomApplication {
    public static void main(String[] args) {
        SpringApplication.run(RoomApplication.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RoomRepository repository, BedRepository bedRepository){
        return args -> {
//            Room room1 = Room.builder()
//                    .roomName("Single Room")
//                    .roomCustomName("Custom Single Room")
//                    .createdAt(LocalDateTime.now())
//                    .pricePerNight(65.00)
//                    .numberOfPeopleCanAccommodate(2)
//                    .propertyId(1L)
//                    .size(25)
//                    .measurement(Measurement.SQFeet)
//                    .imageUrl("www.google.com")
//                    .build();
//
//            Room room = repository.saveAndFlush(room1);
//            bedRepository.save(Bed.builder()
//                            .room(room)
//                            .type(BedType.builder()
//                                    .type("Double")
//                                    .build())
//                            .createdAt(LocalDateTime.now())
//                    .build());
            Optional<Room> room = repository.findById(1L);
            room.get().getBeds().stream().forEach(bed -> {
                System.out.println(bed);
            });
        };
    }
}
