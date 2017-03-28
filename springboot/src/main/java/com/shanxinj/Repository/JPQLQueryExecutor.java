package com.shanxinj.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by kanglg on 2017/3/28.
 */
public interface JPQLQueryExecutor {
    Page findAll(JPQLNamedQuery query, Pageable pageable);
    <T> Page<T> findAll(JPQLNamedQuery query, Pageable pageable, Class<T> clazz);
}
