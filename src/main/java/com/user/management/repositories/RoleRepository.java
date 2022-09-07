package com.user.management.repositories;

import com.user.management.models.Role;
import com.user.management.projection.RoleProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    RoleProjection getRoleById(Long id);

    Role getRoleByName(String name);

    List<RoleProjection> findAllBy();
}
