package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.dto.AddressDto;
import ch.scorndes.contractsapi.model.Address;
import ch.scorndes.contractsapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AddressMapper extends UserIdMapperSupport {

    default AddressDto toDto(Address address) {
        return new AddressDto(
                address.getId(),
                address.isPrincipale(),
                address.getUser() != null ? address.getUser().getId() : null,
                address.getNumero(),
                address.getLigne1(),
                address.getLigne2(),
                address.getCodePostal(),
                address.getVille(),
                address.getPays()
        );
    }

    default Address toModel(AddressDto dto) {
        Address address = new Address();
        address.setId(dto.id());
        address.setPrincipale(dto.principale());
        address.setNumero(dto.numero());
        address.setLigne1(dto.ligne1());
        address.setLigne2(dto.ligne2());
        address.setCodePostal(dto.codePostal());
        address.setVille(dto.ville());
        address.setPays(dto.pays());
        if (dto.userId() != null) {
            User user = new User();
            user.setId(dto.userId());
            address.setUser(user);
        }
        return address;
    }

}
