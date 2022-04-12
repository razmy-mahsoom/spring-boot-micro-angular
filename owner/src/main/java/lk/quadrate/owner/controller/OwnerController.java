package lk.quadrate.owner.controller;

import lk.quadrate.clients.owner.OwnerClientResponse;
import lk.quadrate.owner.entity.Gender;
import lk.quadrate.owner.entity.Owner;
import lk.quadrate.owner.model.OwnerModel;
import lk.quadrate.owner.service.OwnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
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
@Slf4j
public class OwnerController {

    private final OwnerService service;
    private final ModelMapper modelMapper;


    @PostMapping
    @PreAuthorize("hasRole('owner')")
    public void saveOwner(@Validated @RequestBody OwnerModel ownerModel)  {
        service.saveOwner(ownerModel);
    }

    @GetMapping(path = "{ownerId}")
    @PreAuthorize("hasRole('owner')")
    OwnerClientResponse getOwnerById(@PathVariable("ownerId") Long ownerId){
        Owner owner = service.getOwnerById(ownerId);
        OwnerClientResponse ownerClientResponse = modelMapper.map(owner,OwnerClientResponse.class);
        return ownerClientResponse;
    }
    @GetMapping(path = "/user/{userId}")
    @PreAuthorize("hasRole('owner')")
    OwnerClientResponse getOwnerByUserId(@PathVariable("userId") String userId){
        Owner owner = service.getOwnerByUserId(userId);
        OwnerClientResponse ownerClientResponse = modelMapper.map(owner,OwnerClientResponse.class);
        return ownerClientResponse;
    }

    @GetMapping(path = "/authentication")
    @PreAuthorize("hasRole('owner')")
    OwnerClientResponse getOwnerByAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        Owner owner = service.getOwnerByUserId(userId);
        OwnerClientResponse ownerClientResponse = modelMapper.map(owner,OwnerClientResponse.class);

        //Keycloak Implementation
        Authentication auth  = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal = (KeycloakPrincipal) auth.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken token = session.getToken();
        log.info("Username :{}",token.getPreferredUsername());
        log.info("Email :{}",token.getEmail());
        log.info("Last Name :{}",token.getFamilyName());
        log.info("First Name :{}",token.getGivenName());
        log.info("realmName :{}",token.getIssuer());
        log.info("Keycloak UserID :{}",token.getId());
        log.info("User ID :{}",userId);
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
