package com.kubacki.services;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface CRUDService<T> {
    Iterable<?> listAll();
    T getById(Integer id);
    T saveOrUpdate(T domainObject);
    void delete(Integer id);

}
