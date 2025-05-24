package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.Address;

import java.util.List;
import java.util.UUID;

public interface AddressRepositoryCustom {

    List<Address> findByUserId(UUID uuid);

}
