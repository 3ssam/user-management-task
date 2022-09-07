package com.user.management.config;

import com.user.management.models.User;
import com.user.management.repositories.UserRepository;
import com.user.management.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditConfiguration {
    @Autowired
    private UserRepository userRepository;
    @Bean
    AuditorAware<User> auditorProvider() {
        return () -> Optional.of(userRepository.getOne(CurrentUser.getId()));
    }
}
