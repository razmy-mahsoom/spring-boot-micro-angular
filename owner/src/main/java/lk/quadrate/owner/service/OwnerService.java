package lk.quadrate.owner.service;

import lk.quadrate.owner.entity.Owner;
import lk.quadrate.owner.exception.OwnerExistException;
import lk.quadrate.owner.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
@AllArgsConstructor
@Slf4j
public class OwnerService {
    private final OwnerRepository repository;

    public void saveOwner(Owner owner){
        try {
            repository.save(owner);
        }catch (DataIntegrityViolationException e){
            throw new OwnerExistException("Owner Already Exists");
        }
    }
}
