package com.shanxinj.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户管理
 * Created by kanglg on 2017/3/23.
 */
@Controller
@RequestMapping("/users")
public class UserConfigController {
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "webapp/user/user-index";
    }
}
