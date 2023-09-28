package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    List<Owner> getAllOwners();

    Optional<Owner> getOwnerById(Integer id);

    void saveOwner(Owner newOwner);

    Owner updateOwner(Owner updatedOwner, Integer id);

    void deleteOwner(Integer id);

//    void deleteOwner(Owner owner);
}
