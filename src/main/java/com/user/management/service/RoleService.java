package com.user.management.service;

import com.user.management.models.Authority;
import com.user.management.models.Role;
import com.user.management.models.DTO.RoleDTO;
import com.user.management.projection.RoleProjection;
import com.user.management.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthorityService authorityService;

    @Transactional
    public RoleProjection createRole(RoleDTO RoleDTO) {
        Role role = new Role();
        role.setName(RoleDTO.getName());
        role.setStatus(RoleDTO.getStatus());
        role = roleRepository.save(role);
        return roleRepository.getRoleById(role.getId());
    }

    @Transactional
    public RoleProjection updateRole(RoleDTO RoleDTO, Long id) throws Exception {
        Role role = roleRepository.findById(id).get();
        if (role == null) {
            throw new Exception("Role not found");
        }
        role.setStatus(RoleDTO.getStatus());
        role = roleRepository.save(role);
        return roleRepository.getRoleById(role.getId());
    }


    public List<RoleProjection> getAllRoles() {
        return roleRepository.findAllBy();
    }

    public RoleProjection getRole(Long id) throws Exception {
        RoleProjection roleProjection = roleRepository.getRoleById(id);
        if (roleProjection == null) {
            throw new Exception("Role not found");
        }
        return roleProjection;
    }

    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Transactional
    public void assignAuthorityToRole(Long roleId, Long authorityId) throws Exception {
        Role role = roleRepository.findById(roleId).get();
        if (role == null) {
            throw new Exception("Role not found");
        }
        Authority authority = authorityService.getAuthorityById(authorityId);
        if (role == null) {
            throw new Exception("Authority not found");
        }
        role.getAuthorities().add(authority);
        roleRepository.save(role);
    }

    @Transactional
    public void assignAuthorityToRole(Long roleId, String authorityName) throws Exception {
        Role role = roleRepository.findById(roleId).get();
        if (role == null) {
            throw new Exception("Role not found");
        }
        Authority authority = authorityService.getAuthorityByName(authorityName);
        if (role == null) {
            throw new Exception("Authority not found");
        }
        role.getAuthorities().add(authority);
        roleRepository.save(role);
    }

    public Role getRoleByName(String name) throws Exception {
        Role role = roleRepository.getRoleByName(name);
        if (role == null) {
            throw new Exception("Role not found");
        }
        return role;
    }


}
