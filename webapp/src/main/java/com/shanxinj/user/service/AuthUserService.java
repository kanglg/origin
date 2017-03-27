package com.shanxinj.user.service;

import com.shanxinj.common.BaseService;
import com.shanxinj.user.repository.AuthUserRepository;
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
    private final AuthUserRepository authUserRepository;

    @Autowired
    public AuthUserService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    public Page findUsersWithPage(int pageNum, int pageSize) {
        logger.info("findAll");
        return authUserRepository.findAll(PageUtils.buildPageRequest(pageNum, pageSize));
    }
}
