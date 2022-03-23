package lk.quadrate.owner.controller;

import lk.quadrate.clients.owner.OwnerClientResponse;
import lk.quadrate.owner.entity.Owner;
import lk.quadrate.owner.service.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/owner")
@AllArgsConstructor
public class OwnerController {

    private final OwnerService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public void saveOwner(@Validated @RequestBody Owner owner)  {
        service.saveOwner(owner);
    }

    @GetMapping(path = "{ownerId}")
    OwnerClientResponse getOwnerById(@PathVariable("ownerId") Long ownerId){
        Owner owner = service.getOwnerById(ownerId);
        OwnerClientResponse ownerClientResponse = modelMapper.map(owner,OwnerClientResponse.class);
        return ownerClientResponse;
    }
}
