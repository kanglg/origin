package com.shanxinj.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by kanglg on 2017/3/24.
 */
public abstract class BaseService {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
