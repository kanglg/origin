package com.shanxinj.auth.filter;

import com.shanxinj.auth.Constants;
import com.shanxinj.auth.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by kanglg on 2017/3/27.
 */
public class SysUserLoginFilter extends FormAuthenticationFilter {
    private final UserService userService;

    @Autowired
    public SysUserLoginFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        if (this.isAccessAllowed(request, response, mappedValue) || this.onAccessDenied(request, response, mappedValue)) {
            String username = (String) SecurityUtils.getSubject().getPrincipal();
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            httpServletRequest.getSession().setAttribute(Constants.CURRENT_USER,userService.findUserByAccount(username));
            return true;
        }
        return false;
    }
}
