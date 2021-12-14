package com.depanneur_ste_helene.inventory_system.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Transactional(readOnly = true)
    List<Product> findByProductId(Integer productId);

//    @Query(value = "SELECT * FROM Product WHERE bar_code = :barCode", nativeQuery = true)
    Optional<Product> findProductByBarCode(Integer barCode);
    void deleteProduct(Integer barCode);
}
