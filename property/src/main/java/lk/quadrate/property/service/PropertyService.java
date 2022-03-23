package lk.quadrate.property.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import feign.FeignException;
import lk.quadrate.clients.owner.OwnerClient;
import lk.quadrate.clients.owner.OwnerClientResponse;
import lk.quadrate.property.entity.Property;
import lk.quadrate.property.entity.PropertyType;
import lk.quadrate.property.exceptions.OwnerPropertyNotFoundException;
import lk.quadrate.property.exceptions.PropertyTypeNotFoundException;
import lk.quadrate.property.model.PropertyModel;
import lk.quadrate.property.repository.PropertyRepository;
import lk.quadrate.property.repository.PropertyTypeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.el.PropertyNotFoundException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class PropertyService {

    private final PropertyRepository repository;
    private final PropertyTypeRepository typeRepository;
    private final OwnerClient ownerClient;

    public List<Property> findAllPropertyByOwnerId(Long ownerId){
        return repository.findAllByOwnerId(ownerId);
    }

    public Property findPropertyByOwnerId(Long ownerId){
        return repository.findByOwnerId(ownerId)
                .orElseThrow(()->{throw new OwnerPropertyNotFoundException("");});
    }

    public void saveProperty(PropertyModel propertyModel){
        Optional<PropertyType> propertyType = Optional.ofNullable(typeRepository
                .findById(propertyModel.getPropertyTypeId()).orElseThrow(() -> {
                    throw new PropertyTypeNotFoundException("Property Type" + propertyModel.getPropertyTypeId() + "Not Found");
                }));

        OwnerClientResponse ownerClientResponse = ownerClient.getOwnerById(propertyModel.getOwnerId());
        if(ownerClientResponse!=null){
            Property property = Property.builder()
                    .type(propertyType.get())
                    .name(propertyModel.getName())
                    .location(propertyModel.getLocation())
                    .imageUrl(propertyModel.getImageUrl())
                    .ownerId(ownerClientResponse.getId()).build();
            repository.save(property);

            //TODO:: Notification--> new Property added
        }else {
            throw new RuntimeException("Internal Server Error!!");
        }

    }
}
