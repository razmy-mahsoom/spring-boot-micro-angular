package lk.quadrate.owner.controller;

import lk.quadrate.clients.owner.OwnerClientResponse;
import lk.quadrate.owner.entity.Owner;
import lk.quadrate.owner.service.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/owner")
@AllArgsConstructor
public class OwnerController {

    private final OwnerService service;
    private final ModelMapper modelMapper;


    @PostMapping
    @PreAuthorize("hasRole('owner')")
    public void saveOwner(@Validated @RequestBody Owner owner)  {
        service.saveOwner(owner);
    }

    @GetMapping(path = "{ownerId}")
    OwnerClientResponse getOwnerById(@PathVariable("ownerId") Long ownerId){
        Owner owner = service.getOwnerById(ownerId);
        OwnerClientResponse ownerClientResponse = modelMapper.map(owner,OwnerClientResponse.class);
        return ownerClientResponse;
    }

    @GetMapping("/principal")
    @PreAuthorize("hasRole('owner')")
        public ResponseEntity<Object> getToken(Principal principal){
        return new ResponseEntity<>(principal.getName(), HttpStatus.ACCEPTED);
        }
}
