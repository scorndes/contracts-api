package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByIdWithMainAdresses(UUID userId) {
        String jpqlQuery = "SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.addresses a WHERE u.id = :userId AND a.principale = true";
        return entityManager.createQuery(jpqlQuery, User.class)
                .setParameter("userId", userId)
                .getResultStream()
                .findFirst();
    }

}
