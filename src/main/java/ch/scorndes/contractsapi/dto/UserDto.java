package ch.scorndes.contractsapi.dto;

import java.util.List;
import java.util.UUID;

public record UserDto (
    UUID id,
    String username,
    String password,
    String email,
    List<AddressDto> addresses,
    List<PortfolioDto> portfolios
){}
