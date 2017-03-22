package com.shanxinj.auth.realm;

import com.shanxinj.auth.entity.SysUser;
import com.shanxinj.auth.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm实现
 * Created by kanglg on 2017/2/20.
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private UserService userService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String account = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(account));
        authorizationInfo.setStringPermissions(userService.findPermissions(account));
        logger.info("获取授权信息");
        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal();
        SysUser user = userService.findUserByAccount(account);
        if (user == null) {
            throw new UnknownAccountException();
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(account);
        logger.info("获取用户信息");
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), credentialsSalt, getName());
    }
}
