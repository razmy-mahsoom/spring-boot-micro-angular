package lk.quadrate.owner.controller;

import lk.quadrate.owner.entity.Owner;
import lk.quadrate.owner.exception.OwnerExistException;
import lk.quadrate.owner.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("api/v1/owner")
@AllArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @PostMapping
    public void saveOwner(@Validated @RequestBody Owner owner)  {
        service.saveOwner(owner);
    }
}
