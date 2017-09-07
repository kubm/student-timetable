package com.kubacki.services;

import com.kubacki.domain.Role;

import java.util.List;

public interface RoleService extends CRUDService<Role>{
    List<Role> findAllByRole(String role);
    Role findByRole(String role);
}
