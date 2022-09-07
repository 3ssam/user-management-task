package com.user.management.models.DTO;

import com.user.management.models.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UserDTO {
    @NotBlank(message = "This field is required field")
    private String email;
    @NotBlank(message = "This field is required field")
    private String password;
    @NotNull(message = "This field is required field")
    private Boolean activated;
    @NotNull(message = "This field is required field")
    private Boolean suspended;
    @NotBlank(message = "This field is required field")
    private String name;
    @NotBlank(message = "This field is required field")
    private String roleName;
}
