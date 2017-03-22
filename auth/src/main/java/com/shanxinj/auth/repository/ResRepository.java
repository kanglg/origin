package com.shanxinj.auth.repository;

import com.shanxinj.auth.entity.SysUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * 资源DAO
 * Created by kanglg on 2017/2/23.
 */
public interface ResRepository extends CrudRepository<SysUser, String> {
    /**
     * 通过账号获取权限
     * @param username 账号
     * @return 权限集合
     */
    @Query(value = "select res.prmtDef from SysUser user, SysUserRoleRel rel1, SysRole role, SysRoleResRel rel2, SysRes res where user.userId = rel1.id.userId and rel1.id.roleId = role.roleId and role.roleId = rel2.id.roleId and rel2.id.resId = res.resId and user.username = ?1 ")
    Set<String> findPrmtByUsername(String username);
}
