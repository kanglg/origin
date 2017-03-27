package com.shanxinj.user.web;

import com.shanxinj.user.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户管理
 * Created by kanglg on 2017/3/23.
 */
@Controller
@RequestMapping("/auth/users")
public class UserConfigController {
    private final AuthUserService userService;
    @Autowired
    public UserConfigController(AuthUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("users", userService.findUsersWithPage(1,10));
        return "webapp/user/user-index";
    }
}
