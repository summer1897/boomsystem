package com.boom.rbac.controller;

import com.boom.rbac.domain.User;
import com.boom.rbac.service.IUserService;
import com.boom.utils.EncryptionUtils;
import com.boom.utils.RandomIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by summer on 2017/12/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/lists.json",method = RequestMethod.GET)
    @ResponseBody
    public List<User> lists() {
        log.info("method:GET ===> request path:/user/list===>UserController.list()");
        List<User> users = userService.queryAll();
       /* User user = new User();
        user.setId(RandomIdGenerator.generateRandomId().toString());
        user.setUserName("summer");
        user.setNickName("summer");
        user.setSalt(RandomIdGenerator.geneateUUID().toString());
        user.setPassword(EncryptionUtils.encrypt("123456",user.getCredentialSalt()));
        user.setState((byte)0);*/
        return users;
    }

    @RequestMapping("/list.json/{name}")
    @ResponseBody
    public User list(@PathVariable("name") String name) {
        log.info("query user info by name===>UserController.list()");
        User user =  userService.queryByName(name);
        return user;
    }
}
