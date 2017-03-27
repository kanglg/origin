package com.shanxinj.login.web.vo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Created by kanglg on 2017/3/24.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public String index(@PathVariable("code") String code) {
        return "error/" + code;
    }
}
