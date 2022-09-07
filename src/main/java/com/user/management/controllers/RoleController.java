package com.user.management.controllers;

import com.user.management.models.DTO.RoleDTO;
import com.user.management.response.ApiResponse;
import com.user.management.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@Api(tags = "Role", description = "this API for Do any CRUD Operation on Role Entity")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAuthority('CREATE_ROLE')")
    @PostMapping()
    public ApiResponse createRole(@Validated @RequestBody RoleDTO roleDTO) throws Exception {
        return ApiResponse.created(roleService.createRole(roleDTO));
    }

    @PreAuthorize("hasAuthority('UPDATE_ROLE')")
    @PutMapping("{roleId}")
    public ApiResponse updateRole(@PathVariable Long roleId, @Validated @RequestBody RoleDTO roleDTO) throws Exception {
        return ApiResponse.updated(roleService.updateRole(roleDTO, roleId));
    }

    @PreAuthorize("hasAuthority('DELETE_ROLE')")
    @DeleteMapping("{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
    }

    @PreAuthorize("hasAuthority('READ_ROLE')")
    @GetMapping({"{roleId}"})
    public ApiResponse getRole(@PathVariable Long roleId) throws Exception {
        return ApiResponse.ok(roleService.getRole(roleId));
    }

    @PreAuthorize("hasAuthority('READ_ALL_ROLES')")
    @GetMapping()
    public ApiResponse getRoles() {
        return ApiResponse.created(roleService.getAllRoles());
    }

    @PreAuthorize("hasAuthority('ASSIGN_AUTHORITY_TO_ROLE')")
    @GetMapping("assignAuthority/{roleId}/name")
    public void assignAuthorityToRole(@PathVariable Long roleId, @RequestParam String authorityName) throws Exception {
        roleService.assignAuthorityToRole(roleId, authorityName);
    }

    @PreAuthorize("hasAuthority('ASSIGN_AUTHORITY_TO_ROLE')")
    @GetMapping("assignAuthority/{roleId}/id")
    public void assignAuthorityToRole(@PathVariable Long roleId, @RequestParam Long authorityId) throws Exception {
        roleService.assignAuthorityToRole(roleId, authorityId);
    }

}
