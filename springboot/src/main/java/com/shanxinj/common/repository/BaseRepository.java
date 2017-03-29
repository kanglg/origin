package com.shanxinj.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 公共repo接口
 * Created by kanglg on 2017/3/28.
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    /**
     * jpql分页命名查询
     * @param query 查询接口
     * @param pageable 分页
     * @return page
     */
    Page<T> findAll(JPQLNamedQuery query, Pageable pageable);

    /**
     * jpql分页命名查询
     * @param query 查询接口
     * @param pageable 分页
     * @param clazz 返回类
     * @param <E> 类名
     * @return page
     */
    <E> Page<E> findAll(JPQLNamedQuery query, Pageable pageable, Class<E> clazz);

    List findAll(JPQLNamedQuery query);

    <E> List<E> findAll(JPQLNamedQuery query, Class<E> clazz);
}
