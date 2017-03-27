package com.shanxinj.common;

import com.shanxinj.util.PageUtils;
import org.springframework.data.domain.PageRequest;

/**
 * 分页VO
 * Created by kanglg on 2017/3/24.
 */
public class Pager {
    private int pageNum = -1;
    private int pageSize = 0;
    private String sortType = null;
    private String direction = null;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageRequest getPageRequest() {
        return PageUtils.buildPageRequest(pageNum, pageSize, sortType, direction);
    }
}
