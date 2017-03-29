package com.shanxinj.common.repository.impl;

import com.shanxinj.common.repository.BaseRepository;
import com.shanxinj.common.repository.JPQLNamedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 公共Repo实现
 * Created by kanglg on 2017/3/28.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final EntityManager em;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
    }

    public Page<T> findAll(JPQLNamedQuery query, Pageable pageable) {
        String jpql = query.getJPQL();
        Map<String, Object> params = query.getNamedParam();
        Query q = em.createQuery(jpql);
//        Query c = em.createQuery(buildCountQuery(jpql));
        buildCountSql(jpql);
        for (String key : params.keySet()) {
            Object param = params.get(key);
            q.setParameter(key, param);
//            c.setParameter(key, param);
        }
        q.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        q.setMaxResults(pageable.getPageSize());
        @SuppressWarnings("unchecked")
        List<T> list = q.getResultList();
//        long total = (Long) c.getSingleResult();
        return new PageImpl<T>(list, pageable, list.size());
    }

    public <E> Page<E> findAll(JPQLNamedQuery query, Pageable pageable, Class<E> clazz) {
        String jpql = query.getJPQL();
        Map<String, Object> params = query.getNamedParam();
        TypedQuery<E> q = em.createQuery(jpql, clazz);
//        TypedQuery<E> c = em.createQuery(buildCountQuery(jpql), clazz);
        for (String key : params.keySet()) {
            Object param = params.get(key);
            q.setParameter(key, param);
        }
        q.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        q.setMaxResults(pageable.getPageSize());
        List<E> list = q.getResultList();
//        long total = (Long) c.getSingleResult();
        return new PageImpl<E>(list, pageable, list.size());
    }

    private String buildCountQuery(String jpql) {
        String countql = "select count(*) from ({jpql}) t";
        logger.info(StringUtils.replace(countql, "{jpql}", jpql));
        return StringUtils.replace(countql, "{jpql}", jpql);
    }

    public SessionFactory getSessionFactory() {
        Session session = (Session) em.getDelegate();
        return session.getSessionFactory();
    }

    private String buildCountSql(String hql) {
        Session session = (Session) em.getDelegate();
        SessionFactoryImpl sessionFactory = (SessionFactoryImpl) session.getSessionFactory();
        QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(hql, hql, Collections.EMPTY_MAP, sessionFactory);
        queryTranslator.compile(Collections.EMPTY_MAP, false);
        String sql = queryTranslator.getSQLString();
        logger.info("sql:" + sql);
        return sql;
    }
}
