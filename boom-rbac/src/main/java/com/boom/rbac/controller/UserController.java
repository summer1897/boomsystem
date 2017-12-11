package com.boom.rbac.controller;

import com.boom.rbac.domain.User;
import com.boom.utils.EncryptionUtils;
import com.boom.utils.RandomIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by summer on 2017/12/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public User list() {
        log.info("method:GET ===> request path:/user/list===>UserController.list()");
        User user = new User();
        user.setId(RandomIdGenerator.generateRandomId().toString());
        user.setUserName("summer");
        user.setNickName("summer");
        user.setSalt(RandomIdGenerator.geneateUUID().toString());
        user.setPassword(EncryptionUtils.encrypt("123456",user.getCredentialSalt()));
        user.setState((byte)0);
        return user;
    }
}
