package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.Address;
import ch.scorndes.contractsapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>, AddressRepositoryCustom {

}
