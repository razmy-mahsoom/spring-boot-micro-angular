package lk.quadrate.owner.controller;

import lk.quadrate.clients.owner.OwnerClientResponse;
import lk.quadrate.owner.entity.Gender;
import lk.quadrate.owner.entity.Owner;
import lk.quadrate.owner.model.OwnerModel;
import lk.quadrate.owner.service.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/owner")
@CrossOrigin(origins = "http://localhost:4200/")
@AllArgsConstructor
public class OwnerController {

    private final OwnerService service;
    private final ModelMapper modelMapper;


    @PostMapping
    @PreAuthorize("hasRole('owner')")
    public void saveOwner(@Validated @RequestBody OwnerModel ownerModel)  {
        service.saveOwner(ownerModel);
    }

    @GetMapping(path = "{ownerId}")
    OwnerClientResponse getOwnerById(@PathVariable("ownerId") Long ownerId){
        Owner owner = service.getOwnerById(ownerId);
        OwnerClientResponse ownerClientResponse = modelMapper.map(owner,OwnerClientResponse.class);
        return ownerClientResponse;
    }
    @GetMapping(path = "/user/{userId}")
    OwnerClientResponse getOwnerByUserId(@PathVariable("userId") String userId){
        Owner owner = service.getOwnerByUserId(userId);
        OwnerClientResponse ownerClientResponse = modelMapper.map(owner,OwnerClientResponse.class);
        return ownerClientResponse;
    }

    @GetMapping("/principal")
   // @PreAuthorize("hasRole('owner')")
    public ResponseEntity<Object> getToken(Principal principal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(principal.getName(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/gender")
    public ResponseEntity<Object> getGender(){
        return new ResponseEntity<>(Gender.values(),HttpStatus.OK);
    }

}
