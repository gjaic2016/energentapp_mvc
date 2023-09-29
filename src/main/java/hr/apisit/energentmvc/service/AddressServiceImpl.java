package hr.apisit.energentmvc.service;

import hr.apisit.energentmvc.domain.Address;
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
//        return Optional.empty();
    }

    @Override
    public void saveAddress(Address newAddress) {
        addressRepositoryJpa.save(newAddress);
    }

    @Override
    public Optional<Address> updateAddress(Address updatedAddress, Integer id) {
        //TODO Address update
        return Optional.empty();
    }

    @Override
    public void deleteAddress(Integer id) {
        addressRepositoryJpa.deleteById(id);
    }
}
