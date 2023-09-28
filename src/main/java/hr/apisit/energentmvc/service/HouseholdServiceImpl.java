package hr.apisit.energentmvc.service;


import hr.apisit.energentmvc.domain.Household;
import hr.apisit.energentmvc.jpaRepository.HouseholdRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class HouseholdServiceImpl implements HouseholdService{

  private HouseholdRepositoryJpa householdRepositoryJpa;

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepositoryJpa.findAll();
    }

    @Override
    public Optional<Household> getHouseholdById(Integer id) {
        return householdRepositoryJpa.findById(id);
    }

    @Override
    public void saveHousehold(Household newHousehold) {
        householdRepositoryJpa.save(newHousehold);
    }

    @Override
    public Optional<Household> updateHousehold(Household updatedHousehold, Integer id) {
        //TODO Household update
        return Optional.of(householdRepositoryJpa.save(updatedHousehold));
    }

    @Override
    public void deleteHousehold(Integer id) {
        householdRepositoryJpa.deleteById(id);
    }

}
