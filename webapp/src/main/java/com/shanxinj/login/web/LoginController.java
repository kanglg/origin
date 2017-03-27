package com.shanxinj.login.web;

import com.shanxinj.user.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登陆
 * Created by kanglg on 2017/3/10.
 */
@Controller
public class LoginController {
//    @RequestMapping(method = RequestMethod.POST)
//    public String login(String username, String password) {
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        Subject subject = SecurityUtils.getSubject();
//        subject.login(token);
//        return "redirect:/index";
//    }
    private final AuthUserService authUserService;

    @Autowired
    public LoginController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {
        return "webapp/login";
    }
}
