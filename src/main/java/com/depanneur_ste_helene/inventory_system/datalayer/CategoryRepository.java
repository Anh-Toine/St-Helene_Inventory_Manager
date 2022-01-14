package com.depanneur_ste_helene.inventory_system.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer>{

    @Transactional(readOnly = true)
    boolean existsByCategoryName(String categoryName);
}
