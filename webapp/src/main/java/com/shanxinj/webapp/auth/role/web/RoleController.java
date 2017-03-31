package com.shanxinj.webapp.auth.role.web;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kanglg on 2017/3/30.
 */
@Controller
@RequestMapping("/auth/role")
public class RoleController {
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "webapp/role/role-index";
    }
}
