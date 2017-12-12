package com.boom.rbac.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by summer on 2017/12/12.
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login.html",method = RequestMethod.GET)
    public ModelAndView login() {
        log.info("method:GET;path:/login.html");
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login.html",method = RequestMethod.POST)
    public String loginHandler(@RequestParam(value = "userName",required = true) String userName,
                               @RequestParam(value = "password",required = true) String password) {
        log.info("method:POST;path:/login.html");
        return "index";
    }
}
