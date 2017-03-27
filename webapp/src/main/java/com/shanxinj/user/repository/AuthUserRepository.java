package com.shanxinj.user.repository;

import com.shanxinj.auth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by kanglg on 2017/3/24.
 */
public interface AuthUserRepository extends PagingAndSortingRepository<SysUser, String>, JpaSpecificationExecutor<SysUser> {
}
