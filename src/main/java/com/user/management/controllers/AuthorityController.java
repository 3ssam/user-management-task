package com.user.management.controllers;

import com.user.management.models.DTO.AuthorityDTO;
import com.user.management.response.ApiResponse;
import com.user.management.service.AuthorityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authority")
@Api(tags = "Authority", description = "this API for Do any CRUD Operation on Authority Entity")
public class AuthorityController {


    @Autowired
    private AuthorityService authorityService;

    @PreAuthorize("hasAuthority('CREATE_Authority')")
    @PostMapping()
    public ApiResponse createAuthority(@Validated @RequestBody AuthorityDTO AuthorityDTO) throws Exception {
        return ApiResponse.created(authorityService.createAuthority(AuthorityDTO));
    }

    @PreAuthorize("hasAuthority('UPDATE_Authority')")
    @PutMapping("{AuthorityId}")
    public ApiResponse updateAuthority(@PathVariable Long AuthorityId, @Validated @RequestBody AuthorityDTO AuthorityDTO) throws Exception {
        return ApiResponse.updated(authorityService.updateAuthority(AuthorityDTO, AuthorityId));
    }

    @PreAuthorize("hasAuthority('DELETE_Authority')")
    @DeleteMapping("{AuthorityId}")
    public void deleteAuthority(@PathVariable Long AuthorityId) {
        authorityService.deleteAuthority(AuthorityId);
    }

    @PreAuthorize("hasAuthority('READ_Authority')")
    @GetMapping({"{AuthorityId}"})
    public ApiResponse getAuthority(@PathVariable Long AuthorityId) throws Exception {
        return ApiResponse.ok(authorityService.getAuthority(AuthorityId));
    }

    @PreAuthorize("hasAuthority('READ_Authorities')")
    @GetMapping()
    public ApiResponse getAuthorities() {
        return ApiResponse.created(authorityService.getAllAuthorities());
    }


}
