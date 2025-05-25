package ch.scorndes.contractsapi.repository;

import ch.scorndes.contractsapi.model.Portfolio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.UUID;

public class PortfolioRepositoryCustomImpl implements PortfolioRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Portfolio> findByUserId(UUID userId) {
        String query = "SELECT DISTINCT p FROM Portfolio p JOIN p.user u JOIN FETCH p.riskProfile LEFT JOIN FETCH p.portfolioAssetClasses pac LEFT JOIN FETCH pac.assetClass WHERE u.id = :userId";
        return entityManager.createQuery(query, Portfolio.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public boolean isPortfolioWithId(UUID id) {
        String query ="SELECT COUNT(p) > 0 FROM Portfolio p WHERE p.id = :id";
        return entityManager.createQuery(query, Boolean.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
