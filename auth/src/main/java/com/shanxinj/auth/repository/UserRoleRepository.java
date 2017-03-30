package com.shanxinj.auth.repository;

import com.shanxinj.auth.entity.SysUserRoleRel;
import com.shanxinj.auth.entity.SysUserRoleRelPK;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户角色关系
 * Created by kanglg on 2017/3/28.
 */
public interface UserRoleRepository extends CrudRepository<SysUserRoleRel, SysUserRoleRelPK> {
    void deleteByUserId(String userId);
}
