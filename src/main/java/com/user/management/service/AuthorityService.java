package com.user.management.service;

import com.user.management.models.Authority;
import com.user.management.models.DTO.AuthorityDTO;
import com.user.management.projection.AuthorityProjection;
import com.user.management.repositories.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Transactional
    public AuthorityProjection createAuthority(AuthorityDTO authorityDTO) {
        Authority authority = new Authority();
        authority.setName(authorityDTO.getName());
        authority.setStatus(authorityDTO.getStatus());
        authority = authorityRepository.save(authority);
        return authorityRepository.getAuthorityById(authority.getId());
    }

    @Transactional
    public AuthorityProjection updateAuthority(AuthorityDTO authorityDTO, Long id) throws Exception {
        Authority authority = authorityRepository.findById(id).get();
        if (authority == null) {
            throw new Exception("Authority not found");
        }
        authority.setStatus(authorityDTO.getStatus());
        authority = authorityRepository.save(authority);
        return authorityRepository.getAuthorityById(authority.getId());
    }


    public List<AuthorityProjection> getAllAuthorities() {
        return authorityRepository.findAllBy();
    }

    public AuthorityProjection getAuthority(Long id) throws Exception {
        AuthorityProjection authorityProjection = authorityRepository.getAuthorityById(id);
        if (authorityProjection == null) {
            throw new Exception("Authority not found");
        }
        return authorityProjection;
    }

    public Authority getAuthorityById(Long id) throws Exception {
        Authority authority = authorityRepository.findAuthorityById(id);
        if (authority == null) {
            throw new Exception("Authority not found");
        }
        return authority;
    }

    public Authority getAuthorityByName(String name) throws Exception {
        Authority authority = authorityRepository.getAuthorityByName(name);
        if (authority == null) {
            throw new Exception("Authority not found");
        }
        return authority;
    }

    @Transactional
    public void deleteAuthority(Long id) {
        authorityRepository.deleteById(id);
    }

}
