package com.shanxinj.common.repository;

import java.util.Map;

/**
 * 命名查询接口
 * Created by kanglg on 2017/3/28.
 */
public interface JPQLNamedQuery extends JPQLQuery {
    Map<String, Object> getNamedParam();
}
