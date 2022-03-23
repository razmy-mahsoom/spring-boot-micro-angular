package lk.quadrate.property.model;

import lk.quadrate.property.entity.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyModel {

    @NotNull(message = "Property Type Cannot be empty")
    private Long propertyTypeId;
    @NotBlank@NotEmpty@NotNull
    private String name;
    @NotBlank@NotEmpty@NotNull
    private String location;
    @NotNull
    private Long ownerId;
    @NotBlank@NotEmpty@NotNull
    private String imageUrl;
}
