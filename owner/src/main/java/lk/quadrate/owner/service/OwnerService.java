package lk.quadrate.owner.service;

import lk.quadrate.owner.entity.Owner;
import lk.quadrate.owner.exception.OwnerExistException;
import lk.quadrate.owner.exception.OwnerNotFountException;
import lk.quadrate.owner.model.OwnerModel;
import lk.quadrate.owner.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class OwnerService {
    private final OwnerRepository repository;

    @Transactional
    public void saveOwner(OwnerModel ownerModel){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Owner owner = Owner.builder()
                .userId(authentication.getName())
                .firstName(ownerModel.getFirstName())
                .lastName(ownerModel.getLastName())
                .gender(ownerModel.getGender())
                .governmentId(ownerModel.getGovernmentId())
                .countryCode(ownerModel.getCountryCode())
                .contactNumber(ownerModel.getContactNumber())
                .address(ownerModel.getAddress())
                .city(ownerModel.getCity())
                .country(ownerModel.getCountry())
                .postalCode(ownerModel.getPostalCode())
                //.dateOfBirth(ownerModel.getDateOfBirth())
                .createdAt(LocalDateTime.now())
                .isProfileCompleted(true)
                .build();
        try {
           repository.save(owner);
        }catch (DataIntegrityViolationException e){
            throw new OwnerExistException("Owner Already Exists");
        }
    }

    @Transactional(readOnly = true)
    public Owner getOwnerById(Long ownerId) {
        return repository.findById(ownerId).orElseThrow(()->{
            throw new OwnerNotFountException("Owner With ID: "+ownerId+" Not Found");
        });
    }
    @Transactional(readOnly = true)
    public Owner getOwnerByUserId(String userId){
        return repository.findOwnerByUserId(userId)
                .orElseThrow(()->{
                    throw new OwnerNotFountException("Owner With UserID: "+userId+" Not Found");
                });
    }


}
