package com.shanxinj.util;

import com.google.common.base.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.data.domain.Sort.Direction;

/**
 * 分页工具
 * Created by kanglg on 2017/3/24.
 */
public class PageUtils {
    public static PageRequest buildPageRequest(int pageNum, int pageSize, String sortType, String direction) {
        Sort sort = null;
        if (Strings.isNullOrEmpty(sortType)) {
            return new PageRequest(pageNum - 1, pageSize);
        } else if (!Strings.isNullOrEmpty(direction)) {
            if (Direction.ASC.equals(direction)) {
                sort = new Sort(Direction.ASC, sortType);
            } else {
                sort = new Sort(Direction.DESC, sortType);
            }
            return new PageRequest(pageNum - 1, pageSize, sort);
        } else {
            sort = new Sort(Direction.ASC, sortType);
            return new PageRequest(pageNum - 1, pageSize, sort);
        }
    }

    public static PageRequest buildPageRequest(int pageNum, int pageSize, String sortType) {
        return buildPageRequest(pageNum, pageSize, sortType, null);
    }

    public static PageRequest buildPageRequest(int pageNum, int pageSize) {
        return buildPageRequest(pageNum, pageSize, null, null);
    }

    public static Map<String, Object> getPageMap(Page<?> objPage) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

//        resultMap.put(Constants.PAGE_RESULT_LIST, objPage.getContent()); // 数据集合，符合查询条件的所有记录数据
//        resultMap.put(Constants.PAGE_TOTAL_NUM, objPage.getTotalElements()); // 总记录数
//        resultMap.put(Constants.PAGE_TOTAL_PAGE, objPage.getTotalPages()); // 总页数
//        resultMap.put(Constants.PAGE_NUM, objPage.getNumber()); // 当前页码
//        resultMap.put(Constants.PAGE_SIZE, objPage.getSize()); // 每页显示数量

        return resultMap;
    }
}
