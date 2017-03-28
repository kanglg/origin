package com.shanxinj.repository.impl;

import com.shanxinj.repository.JPQLNamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
@Transactional(readOnly = true)
public class JPQLQueryExecutorImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Page findAll(JPQLNamedQuery query, Pageable pageable) {
        String jpql = query.getJPQL();
        Map<String, Object> params = query.getNamedParam();
        Query q = entityManager.createNamedQuery(jpql);
        for (String key : params.keySet()) {
            Object param = params.get(key);
            q.setParameter(key, param);
        }
        q.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        q.setMaxResults(pageable.getPageSize());
        List<?> list = q.getResultList();
        long total = q.getMaxResults();
        return new PageImpl(list, pageable, total);
    }

    public <T> Page<T> findAll(JPQLNamedQuery query, Pageable pageable, Class<T> clazz) {
        String jpql = query.getJPQL();
        Map<String, Object> params = query.getNamedParam();
        TypedQuery<T> q = entityManager.createNamedQuery(jpql, clazz);
        for (String key : params.keySet()) {
            Object param = params.get(key);
            q.setParameter(key, param);
        }
        q.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        q.setMaxResults(pageable.getPageSize());
        List<T> list = q.getResultList();
        long total = q.getMaxResults();
        return new PageImpl<T>(list, pageable, total);
    }

}
