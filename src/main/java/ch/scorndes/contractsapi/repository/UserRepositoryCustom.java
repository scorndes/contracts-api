package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositoryCustom {

    Optional<User> findByIdWithMainAdresses(UUID id);

}
