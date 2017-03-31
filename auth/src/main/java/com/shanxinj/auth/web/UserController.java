package com.shanxinj.auth.web;

import com.shanxinj.auth.entity.SysUser;
import com.shanxinj.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * User
 * Created by kanglg on 2017/3/8.
 */
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List index() {
        Set set = userService.findPermissions("admin");
        return userService.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String userId) {
        userService.removeUser(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Page<SysUser> list(@PageableDefault(sort = "creDate", direction = Sort.Direction.DESC) Pageable pageable) {
        return userService.findUserWithPage(pageable);
    }
}
