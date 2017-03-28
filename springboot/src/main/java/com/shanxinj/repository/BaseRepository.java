package com.shanxinj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * Created by kanglg on 2017/3/28.
 */
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T, ID>,JpaSpecificationExecutor<T> {
    Page findAll(JPQLNamedQuery query, Pageable pageable);
    <E> Page<E> findAll(JPQLNamedQuery query, Pageable pageable, Class<E> clazz);
}
