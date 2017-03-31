package com.shanxinj.common.repository.impl;

import com.shanxinj.common.repository.BaseRepository;
import com.shanxinj.common.repository.JPQLNamedQuery;
import org.hibernate.Session;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 公共Repo实现
 * Created by kanglg on 2017/3/28.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final EntityManager em;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    public List findAll(JPQLNamedQuery query) {
        String jpql = query.getJPQL();
        Map<String, Object> params = query.getNamedParam();
        Query q = em.createQuery(jpql);
        if (null != params) {
            for (String key : params.keySet()) {
                Object param = params.get(key);
                q.setParameter(key, param);
            }
        }
        return q.getResultList();
    }

    public Page<T> findAll(JPQLNamedQuery query, Pageable pageable) {
        String jpql = query.getJPQL();
        Map<String, Object> params = query.getNamedParam();
        Query q = em.createQuery(jpql);
        if (null != params) {
            for (String key : params.keySet()) {
                Object param = params.get(key);
                q.setParameter(key, param);
            }
        }
        q.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        q.setMaxResults(pageable.getPageSize());
        @SuppressWarnings("unchecked")
        List<T> list = q.getResultList();
        return new PageImpl<T>(list, pageable, getCount(jpql, params));
    }

    public <E> Page<E> findAll(JPQLNamedQuery query, Pageable pageable, Class<E> clazz) {
        String jpql = query.getJPQL();
        Map<String, Object> params = query.getNamedParam();
        TypedQuery<E> q = em.createQuery(jpql, clazz);
        if (null != params) {
            for (String key : params.keySet()) {
                Object param = params.get(key);
                q.setParameter(key, param);
            }
        }
        q.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        q.setMaxResults(pageable.getPageSize());
        List<E> list = q.getResultList();
        return new PageImpl<E>(list, pageable, getCount(jpql, params));
    }

    public <E> List<E> findAll(JPQLNamedQuery query, Class<E> clazz) {
        String jpql = query.getJPQL();
        Map<String, Object> params = query.getNamedParam();
        TypedQuery<E> q = em.createQuery(jpql, clazz);
        if (null != params) {
            for (String key : params.keySet()) {
                Object param = params.get(key);
                q.setParameter(key, param);
            }
        }
        return q.getResultList();
    }

    private long getCount(String hql, Map<String, Object> params) {
        Session session = (Session) em.getDelegate();
        SessionFactoryImpl sessionFactory = (SessionFactoryImpl) session.getSessionFactory();
        QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(hql, hql, Collections.EMPTY_MAP, sessionFactory);
        queryTranslator.compile(Collections.EMPTY_MAP, false);
        String sql = queryTranslator.getSQLString();
        sql = StringUtils.substringBefore(sql, "order by");
        StringBuffer stb = new StringBuffer(1000);
        stb.append("select count(1) from (").append(sql).append(") t");
        Query query = em.createNativeQuery(stb.toString());
        if (null != params) {
            for (String key : params.keySet()) {
                int[] locations = queryTranslator.getParameterTranslations().getNamedParameterSqlLocations(key);
                for (int location : locations) {
                    query.setParameter(location + 1, params.get(key));
                }
            }
        }
        BigInteger integer = (BigInteger) query.getSingleResult();
        return integer.longValue();
    }
}
