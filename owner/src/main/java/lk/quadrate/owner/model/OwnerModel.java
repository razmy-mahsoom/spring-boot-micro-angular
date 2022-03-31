package lk.quadrate.owner.model;

import lk.quadrate.owner.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerModel {

    @NotBlank(message = "First name is mandatory")
    private String firstName;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String governmentId;
    private String countryCode;
    @NotBlank(message = "Contact number is mandatory")
    @Size(min = 10,max = 12,message = "Invalid contact number")
    private String contactNumber;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "Country is mandatory")
    private String country;
    private String postalCode;
    private LocalDateTime dateOfBirth;
}
