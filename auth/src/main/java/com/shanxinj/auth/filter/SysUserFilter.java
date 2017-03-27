package com.shanxinj.auth.filter;

import com.shanxinj.auth.Constants;
import com.shanxinj.auth.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Shiro 过滤器
 * Created by kanglg on 2017/3/11.
 */
public class SysUserFilter extends PathMatchingFilter {
    private final UserService userService;

    @Autowired
    public SysUserFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (username != null) {
            request.setAttribute(Constants.CURRENT_USER, userService.findUserByAccount(username));
        }
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(getPathWithinApplication(request));
        return true;
    }
}
