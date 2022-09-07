package com.user.management.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id", "email", "name"})
public interface UserProjection {

    Long getId();

    public String getEmail();

    public String getName();
}
