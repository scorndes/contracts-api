package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepositoty extends JpaRepository<Address, Integer> {
}
