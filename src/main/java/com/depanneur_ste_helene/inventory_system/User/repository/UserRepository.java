package com.depanneur_ste_helene.inventory_system.User.repository;

import java.util.Optional;

import com.depanneur_ste_helene.inventory_system.User.models.User;
import com.depanneur_ste_helene.inventory_system.User.models.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByUserId(long userId);
}