package com.kubacki.repositories;

import com.kubacki.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role,Integer>{
    List<Role> findAllByRole(String role);
    Role findByRole(String role);
}
