package com.kubacki.services;

import com.kubacki.domain.Role;

import java.util.List;

public interface RoleService extends CRUDService<Role>{
    List<Role> findByRole(String role);
}
