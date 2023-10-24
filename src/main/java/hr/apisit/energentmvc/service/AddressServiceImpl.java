package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Address;
import hr.apisit.energentmvc.domain.Owner;
import hr.apisit.energentmvc.exception.EntityNotFoundException;
import hr.apisit.energentmvc.jpaRepository.AddressRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private AddressRepositoryJpa addressRepositoryJpa;

    @Override
    public List<Address> getAllAddresses() {
        return addressRepositoryJpa.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Integer id) {
        return addressRepositoryJpa.findById(id);
    }

    @Override
    public void saveAddress(Address newAddress) {

        addressRepositoryJpa.save(newAddress);
    }

    @Override
    public Address updateAddress(Address addressToUpdate, Integer originalAddressId) {
        //TODO Address update
        Optional<Address> modifiedAddressOptional = addressRepositoryJpa.findById(originalAddressId);

        if(modifiedAddressOptional.isPresent()) {
            Address modifiedAddress = modifiedAddressOptional.get();

            modifiedAddress.setAddressname(addressToUpdate.getAddressname());
            modifiedAddress.setCity(addressToUpdate.getCity());

            Address newUpdatedAddress = addressRepositoryJpa.save(modifiedAddress);

            return newUpdatedAddress;
        }
        else {
            throw new EntityNotFoundException("There is no Address object for ID = '" + originalAddressId + "'");
        }

    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepositoryJpa.deleteById(id);
    }
}
