package com.boom.rbac.mapper;

import com.boom.rbac.domain.User;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/7 下午10:25
 * @Description User dao层操作接口
 */
public interface UserMapper {

    /**
     * 根据用户名才找用户
     * @param userName
     * @return @{com.boom.rbac.domain.User},否则，返回null
     */
    User queryByName(String userName);

    /**
     * 根据用户名和密码查询用户
     * @param userName
     * @param password
     * @return @{com.boom.rbac.domain.User},否则返回null
     */
    User queryUser(String userName,String password);

    /**
     * 查询所有用户
     * @return @{List<User>}
     */
    List<User> queryAll();

    /**
     * 分页查询所有用户信息
     * @param start 当前页其实位置
     * @param pageNum 当前页显示数据量
     * @return @{List<User>}
     */
    List<User> queryAllByPage(Integer start,Integer pageNum);

}