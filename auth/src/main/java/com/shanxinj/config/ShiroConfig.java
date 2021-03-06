package com.shanxinj.config;

import com.google.common.collect.Maps;
import com.shanxinj.auth.filter.SysUserFilter;
import com.shanxinj.auth.realm.UserRealm;
import com.shanxinj.auth.service.UserService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.Map;

/**
 * Shiro 配置
 * Created by kanglg on 2017/3/8.
 */
@Configuration
public class ShiroConfig {
    @Value("${shiro.credentialsMatcher.hashIterations}")
    private int hashIterations;
    @Value("${shiro.credentialsMatcher.storedCredentialsHexEncoded}")
    private boolean storedCredentialsHexEncoded;

    @Configuration
    protected static class Processor {
        @Bean
        public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
            return new LifecycleBeanPostProcessor();
        }

        @Bean
        public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
            final DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
            proxyCreator.setProxyTargetClass(true);
            return proxyCreator;
        }
    }

    @Bean("credentialsMatcher")
    public HashedCredentialsMatcher getCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(hashIterations);
        credentialsMatcher.setStoredCredentialsHexEncoded(storedCredentialsHexEncoded);
        return credentialsMatcher;
    }

    @Bean(name = "shiroEhcacheManager")
    @DependsOn("lifecycleBeanPostProcessor")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:conf/shiro-ehcache.xml");
        return em;
    }

    @Bean("userRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public UserRealm getUserRealm(HashedCredentialsMatcher credentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCachingEnabled(false);
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setCacheManager(getEhCacheManager());
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean getShiroFilter(SysUserFilter sysUserFilter, DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, Filter> filterMap = Maps.newHashMap();
        filterMap.put("sysUser", sysUserFilter);
        shiroFilterFactoryBean.setFilters(filterMap);
        Map<String, String> filterChainDefinitionMap = Maps.newHashMap();
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/plugins/**", "anon");
        filterChainDefinitionMap.put("/error/**", "anon");
        filterChainDefinitionMap.put("/login", "authc");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "user,sysUser");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/");
        return shiroFilterFactoryBean;
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(DefaultWebSecurityManager securityManager) {
        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        bean.setArguments(new Object[] {
                securityManager
        });
        return bean;
    }

    @Bean
    public SysUserFilter sysUserFilter(UserService userService) {
        return new SysUserFilter(userService);
    }
}
