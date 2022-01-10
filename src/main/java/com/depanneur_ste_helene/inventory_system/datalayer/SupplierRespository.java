package com.depanneur_ste_helene.inventory_system.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface SupplierRespository extends JpaRepository<Supplier, Integer> {
    @Transactional(readOnly = true)
    Optional<Supplier> findSupplierBySupplierName(String name);
}
