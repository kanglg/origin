package com.shanxinj.login.web;

import com.shanxinj.auth.annotation.CurrentUser;
import com.shanxinj.auth.entity.BSysUser;
import com.shanxinj.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注册用户
 * Created by kanglg on 2017/3/20.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(@CurrentUser BSysUser user, Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create(String username, String password) {
        BSysUser user = new BSysUser();
        user.setUserName(username);
        user.setUserAccount(username);
        user.setUserPassword(password);
        userService.addUser(user);
    }
}
