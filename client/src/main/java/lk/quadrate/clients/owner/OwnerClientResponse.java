package lk.quadrate.clients.owner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OwnerClientResponse{
    Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String Gender;
    private String governmentId;
    private String countryCode;
    private String contactNumber;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private LocalDateTime dateOfBirth;
    private LocalDateTime createdAt;
    private Boolean isProfileCompleted;
}
