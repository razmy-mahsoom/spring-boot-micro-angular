package lk.quadrate.property.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Property {

    @Id
    @SequenceGenerator(
            name = "property_sequence",
            sequenceName = "property_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "property_sequence"
    )
    private Long id;
    @OneToOne
    private PropertyType type;
    @Column(nullable = false) @NotBlank
    private String name;
    private String location;
    private Long ownerId;
    private String imageUrl;
    private boolean isCompleted = false;
    private boolean isApproved = false;
}
