package com.shanxinj.auth.service;

import com.google.common.collect.Maps;
import com.shanxinj.auth.Constants;
import com.shanxinj.auth.entity.SysUser;
import com.shanxinj.auth.repository.ResRepository;
import com.shanxinj.auth.repository.RoleRepository;
import com.shanxinj.auth.repository.UserRepository;
import com.shanxinj.auth.repository.UserRoleRepository;
import com.shanxinj.common.repository.JPQLNamedQuery;
import com.shanxinj.utils.EndecryptUtils;
import com.shanxinj.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 定义用户权限的各种方法
 * Created by kanglg on 2017/2/20.
 */
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ResRepository resRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, ResRepository resRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.resRepository = resRepository;
        this.userRoleRepository = userRoleRepository;
    }

    /**
     * 根据ID查找用户
     * @param id ID
     * @return 用户
     */
    public SysUser findUser(String id) {
        return userRepository.findOne(id);
    }

    /**
     * 根据账户名查找用户
     * @param username 账户名
     * @return 用户
     */
    public SysUser findUserByAccount(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 根据账号查找用户角色集合
     * @param username 账号名
     * @return 角色集合
     */
    public Set<String> findRoles(String username) {
        return roleRepository.findByUsername(username);
    }

    /**
     * 根据账号查找用户权限描述
     * @param username 账号名
     * @return 权限描述集合
     */
    public Set<String> findPermissions(String username) {
        return resRepository.findPrmtByUsername(username);
    }

    /**
     * 添加用户
     * @param user 用户
     * @return 持久化用户
     */
    public SysUser addUser(SysUser user) {
        user.setUserId(RandomUtils.uuid());
        user.setPassword(EndecryptUtils.MD5Password(user.getPassword(), user.getUsername()));
        user.setAvl(Constants.BYTE_TRUE);
        user.setCreDate(new Timestamp(System.currentTimeMillis()));
        return userRepository.save(user);
    }

    public List<SysUser> findAll() {
        return (List<SysUser>) userRepository.findAll();
    }

    public void updateUser(SysUser user) {
        userRepository.save(user);
    }


    public Page<SysUser> findUserWithPageTest(Pageable pageable) {
//        PageRequest pageRequest = PageUtils.buildPageRequest(1, 3);
        return userRepository.findAll(new JPQLNamedQuery() {
            public Map<String, Object> getNamedParam() {
                Map<String, Object> params = Maps.newHashMap();
                params.put("username", "admin");
                return null;
            }

            public String getJPQL() {
                return "select user from SysUser user order by user.creDate";
            }
        }, pageable);
    }

    public Page<SysUser> findUserWithPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void removeUser(String userId) {
        userRepository.delete(userId);
        userRoleRepository.deleteByUserId(userId);
    }
}
