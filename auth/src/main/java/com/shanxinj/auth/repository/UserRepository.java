package com.shanxinj.auth.repository;

import com.shanxinj.auth.entity.SysUser;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户DAO
 * Created by kanglg on 2017/2/20.
 */
public interface UserRepository extends CrudRepository<SysUser, String> {
    SysUser findByUsername(String username);
}
