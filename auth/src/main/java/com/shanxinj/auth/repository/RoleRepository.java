package com.shanxinj.auth.repository;

import com.shanxinj.auth.entity.SysRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * 角色DAO
 * Created by kanglg on 2017/2/23.
 */
public interface RoleRepository extends CrudRepository<SysRole, String> {
    /**
     * 通过账号获取用户角色
     * @param username 用户账号
     * @return 角色集合
     */
    @Query("select distinct t2.roleName from SysUser t1, SysRole t2, SysUserRoleRel t3 where t1.userId = t3.userId and t2.roleId = t3.roleId and t1.username = ?1")
    Set<String> findByUsername(String username);
}
