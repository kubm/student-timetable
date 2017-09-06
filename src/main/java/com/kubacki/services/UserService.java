package com.kubacki.services;

import com.kubacki.domain.User;

public interface UserService extends CRUDService<User>{
    User findByUsername(String username);
}
