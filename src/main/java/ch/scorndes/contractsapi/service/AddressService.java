package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.AddressDto;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    List<AddressDto> getAddressesByUserId(UUID id);
}
