package com.shanxinj.common.repository;

import java.util.List;

/**
 * 索引查询接口
 * Created by kanglg on 2017/3/28.
 */
public interface JPQLIndexQuery extends JPQLQuery {
    List getIndexParam();
}
