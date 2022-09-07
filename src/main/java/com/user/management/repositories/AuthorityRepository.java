package com.user.management.repositories;

import com.user.management.models.Authority;
import com.user.management.projection.AuthorityProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    AuthorityProjection getAuthorityById(Long id);

    Authority getAuthorityByName(String name);
    Authority findAuthorityById(Long id);

    List<AuthorityProjection> findAllBy();
}
