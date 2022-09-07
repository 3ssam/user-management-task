package com.user.management.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id", "name"})
public interface AuthorityProjection {

    Long getId();


    public String getName();
}
