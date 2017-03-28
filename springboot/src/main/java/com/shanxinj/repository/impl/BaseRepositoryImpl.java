package com.shanxinj.repository.impl;

import com.shanxinj.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by kanglg on 2017/3/28.
 */
public class BaseRepositoryImpl <T,ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T,ID> {
    private final EntityManager em;
    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.em = entityManager;
    }
}
