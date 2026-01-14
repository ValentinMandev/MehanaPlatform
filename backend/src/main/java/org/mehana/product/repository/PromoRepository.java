package org.mehana.product.repository;

import org.mehana.product.model.entity.PromoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends JpaRepository<PromoEntity, Long> {
}
