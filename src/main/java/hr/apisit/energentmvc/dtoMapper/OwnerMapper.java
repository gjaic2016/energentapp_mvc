package hr.apisit.energentmvc.dtoMapper;

import hr.apisit.energentmvc.domain.Owner;
import hr.apisit.energentmvc.dtoDomain.OwnerDTO;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    public static OwnerDTO mapToDTO(Owner owner) {
        OwnerDTO ownerDTO = new OwnerDTO();

//        ownerDTO.setId(owner.getId());
        ownerDTO.setIme(owner.getIme());
        ownerDTO.setPrezime(owner.getPrezime());
        ownerDTO.setDatumRodenja(owner.getDatumRodenja());
        ownerDTO.setOib(owner.getOib());

        return ownerDTO;
    }

    public static Owner mapToEntity(OwnerDTO ownerDTO) {
        Owner owner = new Owner();

//        owner.setId(ownerDTO.getId());
        owner.setIme(ownerDTO.getIme());
        owner.setPrezime(ownerDTO.getPrezime());
        owner.setDatumRodenja(ownerDTO.getDatumRodenja());
        owner.setOib(ownerDTO.getOib());

        return owner;
    }
}
