package com.boom.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/12 下午8:44
 * @Description
 */
@Controller
public class IndexController {

    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }
}
