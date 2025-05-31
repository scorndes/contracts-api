package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AddressRepositoryImpl implements AddressRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Address> findByUserId(UUID uuid) {
        String jpqlQuery = "SELECT a FROM Address a JOIN a.user u WHERE u.id = :userId ORDER BY a.principale DESC";
        return entityManager.createQuery(jpqlQuery, Address.class)
                .setParameter("userId", uuid)
                .getResultList();
    }

}
