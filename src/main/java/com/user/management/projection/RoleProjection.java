package com.user.management.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id", "name"})
public interface RoleProjection {

    Long getId();

    public String getName();
}
