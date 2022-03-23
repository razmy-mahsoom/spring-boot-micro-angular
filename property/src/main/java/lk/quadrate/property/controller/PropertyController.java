package lk.quadrate.property.controller;

import lk.quadrate.property.model.PropertyModel;
import lk.quadrate.property.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/property")
public class PropertyController {

    private final PropertyService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProperty(@Validated @RequestBody PropertyModel propertyModel){
        service.saveProperty(propertyModel);
    }
}
