package com.depanneur_ste_helene.inventory_system.datalayer.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Transactional(readOnly = true)
    List<Order> findOrderByOrderDate(String orderDate);

}
