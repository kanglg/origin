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
 * 首页
 * Created by kanglg on 2017/3/10.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, @CurrentUser BSysUser user) {
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String regist(@CurrentUser BSysUser user, Model model) {
        model.addAttribute("user", user);
        return "regist";
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public void registSubmit(String username, String password) {
        BSysUser user = new BSysUser();
        user.setUserAccount(username);
        user.setUserName(username);
        user.setUserPassword(password);
        userService.addUser(user);
    }
}
