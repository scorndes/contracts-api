package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<UserDto> getUserWithMainAddress(UUID userId);
}
