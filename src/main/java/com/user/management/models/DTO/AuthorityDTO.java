package com.user.management.models.DTO;

import com.user.management.models.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AuthorityDTO {
    @NotBlank(message = "This field is required field")
    private String name;
    @NotBlank(message = "This field is required field")
    private String nameDescription;
    @NotNull(message = "This field is required field")
    private Boolean status;
}
