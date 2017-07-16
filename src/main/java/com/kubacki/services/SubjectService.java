package com.kubacki.services;

import com.kubacki.domain.Subject;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface SubjectService extends CRUDService<Subject>{

    Subject findByName(String name);
}
