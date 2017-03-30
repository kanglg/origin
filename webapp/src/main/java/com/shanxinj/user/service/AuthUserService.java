package com.shanxinj.user.service;

import com.shanxinj.auth.repository.UserRepository;
import com.shanxinj.common.BaseService;
import com.shanxinj.util.PageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by kanglg on 2017/3/24.
 */
@Service
@Transactional
public class AuthUserService extends BaseService {
    private final Logger logger = LoggerFactory.getLogger(AuthUserService.class);
    private final UserRepository userRepository;

    @Autowired
    public AuthUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page findUsersWithPage(int pageNum, int pageSize) {
        return userRepository.findAll(PageUtils.buildPageRequest(1,10, "creDate", "DESC"));
    }
}
