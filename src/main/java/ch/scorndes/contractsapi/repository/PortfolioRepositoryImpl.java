package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.Portfolio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PortfolioRepositoryImpl implements PortfolioRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Portfolio> findByUserId(UUID userId) {
        String jpqlQuery = "SELECT DISTINCT p FROM Portfolio p JOIN p.user u JOIN FETCH p.riskProfile LEFT JOIN FETCH p.portfolioAssetClasses pac LEFT JOIN FETCH pac.assetClass ac LEFT JOIN FETCH ac.category WHERE u.id = :userId";
        return entityManager.createQuery(jpqlQuery, Portfolio.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public boolean isPortfolioWithId(UUID id) {
        String jpqlQuery ="SELECT COUNT(p) > 0 FROM Portfolio p WHERE p.id = :id";
        return entityManager.createQuery(jpqlQuery, Boolean.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
