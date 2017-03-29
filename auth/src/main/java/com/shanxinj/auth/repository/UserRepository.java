package com.shanxinj.auth.repository;

import com.shanxinj.auth.entity.SysUser;
import com.shanxinj.common.repository.BaseRepository;

/**
 * 用户DAO
 * Created by kanglg on 2017/2/20.
 */
public interface UserRepository extends BaseRepository<SysUser, String> {
    SysUser findByUsername(String username);
}
