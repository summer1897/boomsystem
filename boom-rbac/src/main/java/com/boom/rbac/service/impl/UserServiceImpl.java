package com.boom.rbac.service.impl;

import com.boom.rbac.domain.User;
import com.boom.rbac.mapper.UserMapper;
import com.boom.rbac.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/7 下午10:25
 * @Description
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User queryByName(String userName) {
        return userMapper.queryByName(userName);
    }

    @Override
    public User queryUser(String userName, String password) {
        return userMapper.queryUser(userName,password);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public List<User> queryAllByPagination(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.queryAll();
    }
}
