package com.boom.rbac.service.impl;

import com.boom.rbac.domain.Role;
import com.boom.rbac.exceptions.ServiceException;
import com.boom.rbac.mapper.RoleMapper;
import com.boom.rbac.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/13 下午9:30
 * @Description 服务层角色操作接口实现类
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService{

    private Logger log  = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role queryByName(String name) throws ServiceException {

        return roleMapper.queryByName(name);
    }

    @Override
    public List<Role> queryAll() {
        return roleMapper.queryAll();
    }

    @Override
    public List<Role> queryAllByPagination(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return roleMapper.queryAll();
    }
}
