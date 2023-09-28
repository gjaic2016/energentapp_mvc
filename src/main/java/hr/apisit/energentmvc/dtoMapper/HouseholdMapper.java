package hr.apisit.energentmvc.dtoMapper;

import hr.apisit.energentmvc.domain.Household;
import hr.apisit.energentmvc.domain.Owner;
import hr.apisit.energentmvc.dtoDomain.HouseholdDTO;
import hr.apisit.energentmvc.dtoDomain.OwnerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class HouseholdMapper {

    public static HouseholdDTO mapToDTO(Household household) {
        HouseholdDTO householdDto = new HouseholdDTO();

        householdDto.setId(household.getId());
        householdDto.setAdresa(household.getAdresa());

        List<OwnerDTO> ownerDTOs = household.getVlasnik().stream()
                .map(OwnerMapper::mapToDTO)
                .collect(Collectors.toList());
        householdDto.setVlasnik(ownerDTOs);

        return  householdDto;
    }

    public static Household mapToEntity(HouseholdDTO householdDTO) {
        Household household = new Household();

        household.setId(householdDTO.getId());
        household.setAdresa(householdDTO.getAdresa());

        List<Owner> owners = householdDTO.getVlasnik().stream()
                .map(OwnerMapper::mapToEntity)
                .collect(Collectors.toList());
        household.setVlasnik(owners);

        return household;
    }

}
