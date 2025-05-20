package ch.scorndes.contractsapi.dto;

import java.util.List;
import java.util.UUID;

public record UserDto (
    UUID id,
    String username,
    String email,
    List<AddressDto> addresses
){}
