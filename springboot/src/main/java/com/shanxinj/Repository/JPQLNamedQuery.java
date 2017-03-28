package com.shanxinj.Repository;

import java.util.Map;

/**
 * Created by kanglg on 2017/3/28.
 */
public interface JPQLNamedQuery extends JPQLQuery {
    Map<String, Object> getNamedParam();
}
