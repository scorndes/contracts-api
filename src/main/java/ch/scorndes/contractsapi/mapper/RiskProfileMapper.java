package ch.scorndes.contractsapi.mapper;

import ch.scorndes.contractsapi.dto.RiskProfileDto;
import ch.scorndes.contractsapi.dto.UserDto;
import ch.scorndes.contractsapi.model.RiskProfile;
import ch.scorndes.contractsapi.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RiskProfileMapper {

    RiskProfileDto toDto(RiskProfile riskProfile);

    RiskProfile toModel(RiskProfileDto riskProfileDto);

}
