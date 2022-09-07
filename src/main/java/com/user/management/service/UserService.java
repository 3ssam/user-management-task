package com.user.management.service;

import com.user.management.models.DTO.UserDTO;
import com.user.management.models.User;
import com.user.management.projection.UserProjection;
import com.user.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UserProjection createUser(UserDTO userDTO) throws Exception {
        User user = new User();
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new Exception("Phone Number already exist");
        }
        user.setActivated(userDTO.getActivated());
        user.setSuspended(userDTO.getSuspended());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user = userRepository.save(user);
        user.setRole(roleService.getRoleByName(userDTO.getRoleName()));
        return userRepository.getUserById(user.getId());
    }
}
