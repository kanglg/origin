package com.shanxinj.common.repository.support;

import java.util.List;
import java.util.Map;

/**
 * 查询参数
 * Created by kanglg on 2017/3/31.
 */
public class QueryParam {
    private String query;
    private String countQuery;
    private Map<String, Object> nameParam;
    private List<?> indexParam;
    private String condition;
    private boolean isNative;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getCountQuery() {
        return countQuery;
    }

    public void setCountQuery(String countQuery) {
        this.countQuery = countQuery;
    }

    public Map<String, Object> getNameParam() {
        return nameParam;
    }

    public void setNameParam(Map<String, Object> nameParam) {
        this.nameParam = nameParam;
    }

    public List<?> getIndexParam() {
        return indexParam;
    }

    public void setIndexParam(List<?> indexParam) {
        this.indexParam = indexParam;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isNative() {
        return isNative;
    }

    public void setNative(boolean aNative) {
        isNative = aNative;
    }
}
