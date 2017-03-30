package com.shanxinj.config;

import com.shanxinj.common.repository.BaseRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * jpa java config
 * Created by kanglg on 2017/3/30.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.shanxinj.**.repository",
        repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class
)
public class JpaConfiguration {
}
