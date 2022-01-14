package com.depanneur_ste_helene.inventory_system.User.repository;

import java.util.Optional;

import com.depanneur_ste_helene.inventory_system.User.models.ERole;
import com.depanneur_ste_helene.inventory_system.User.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}