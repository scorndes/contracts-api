package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.dto.AddressDto;
import ch.scorndes.contractsapi.model.Address;
import ch.scorndes.contractsapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AddressMapper extends UserIdMapperSupport {

    @Mapping(target = "userId", source = "user.id")
    AddressDto toDto(Address adress);

    @Mapping(target = "user", source = "userId")
    Address toModel(AddressDto adressDto);

}
