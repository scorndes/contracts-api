package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.dto.AddressDto;
import ch.scorndes.contractsapi.dto.UserDto;
import ch.scorndes.contractsapi.model.Address;
import ch.scorndes.contractsapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = {AddressMapper.class})
public interface UserMapper {

    UserDto toDto(User user);

    User toModel(UserDto userDto);

}