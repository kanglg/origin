package com.shanxinj.login.web;

import com.shanxinj.auth.annotation.CurrentUser;
import com.shanxinj.auth.entity.SysUser;
import com.shanxinj.auth.service.UserService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 首页
 * Created by kanglg on 2017/3/10.
 */
@Controller
@RequestMapping({"/index", "/"})
public class IndexController{
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final IdentityService identityService;
    private final UserService userService;

    @Autowired
    public IndexController(RuntimeService runtimeService, TaskService taskService,
                           IdentityService identityService, UserService userService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.identityService = identityService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, @CurrentUser SysUser user) {
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
                .processDefinitionId("oneTaskProcess").list();
        logger.info("首页登陆...");
        model.addAttribute("user", user);
        model.addAttribute("processInstances", processInstances);
        return "webapp/starter";
    }

    @ModelAttribute("user")
    public SysUser currentUser() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return userService.findUserByAccount(username);
    }
}
