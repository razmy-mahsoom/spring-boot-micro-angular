package lk.quadrate.owner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Owner {

    @Id
    @SequenceGenerator(
            name = "owner_sequence",
            sequenceName = "owner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "owner_sequence"
    )
    private Long id;
    @Column(unique = true)
    private String userId;
    @NotBlank
    @Column(nullable = false)
    private String firstName;
    @NotBlank
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(unique = true)
    @NotBlank
    private String governmentId;
    private String countryCode;
    private String contactNumber;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private LocalDateTime dateOfBirth;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Boolean isProfileCompleted = false;

}
