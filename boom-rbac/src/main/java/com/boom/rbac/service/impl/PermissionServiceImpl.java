package com.boom.rbac.service.impl;

import com.boom.rbac.domain.Permission;
import com.boom.rbac.mapper.PermissionMapper;
import com.boom.rbac.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import com.summer.base.utils.PropertyExtractUtils;
import com.summer.base.utils.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/14 下午11:15
 * @Description 权限服务层操作接口实现类
 */
@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService{

    private static final Logger log = LoggerFactory.getLogger(PermissionServiceImpl.class);
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 生成目录树权限
     * @param permissions
     * @return List<Permission>
     */
    private List<Permission> iteratePermission(List<Permission> permissions) {
        Permission rootPermission = new Permission();
        if (CollectionUtils.isNotEmpty(permissions)) {
            Map<String,Permission> permissionMap = PropertyExtractUtils.extractPropertyFromDomainToMap(permissions,"id",String.class);
            for (String permissionId : permissionMap.keySet()) {
                Permission permission = permissionMap.get(permissionId);
                String parentId = permission.getParentId();
                if (StringUtils.isEmpty(parentId)) {
                    //parentId为empty，表示当前权限为根权限
                    rootPermission.addChildren(permission);
                } else {
                    System.out.println("permissionMap: " + permissionMap);
                    System.out.println("permission parent id: " + parentId);
                    permissionMap.get(parentId).addChildren(permission);
                }
            }
        }
        return rootPermission.getChildren();
    }

    @Override
    public Permission queryById(Integer permissionId) {
        return permissionMapper.queryById(permissionId);
    }

    @Override
    public List<Permission> queryAll() {
        return iteratePermission(permissionMapper.queryAll());
    }

    @Override
    public List<Permission> queryAllAndPagination(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return iteratePermission(permissionMapper.queryAll());
    }

    @Override
    public List<Permission> queryByIds(Set<Integer> permissionIds) {
        return iteratePermission(permissionMapper.queryByIds(permissionIds));
    }

    @Override
    public List<Permission> queryByIdsAndPagination(Set<Integer> permissionIds, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return iteratePermission(permissionMapper.queryByIds(permissionIds));
    }

    @Override
    public List<Permission> queryChildren(Integer permissionId) {
        return iteratePermission(permissionMapper.queryChildren(permissionId));
    }

    @Override
    public List<Permission> queryChildren(Integer permissionId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return iteratePermission(permissionMapper.queryChildren(permissionId));
    }

    @Override
    public List<Permission> queryAllChildren(Set<Integer> permissionIds) {
        return iteratePermission(permissionMapper.queryAllChildren(permissionIds));
    }

    @Override
    public List<Permission> queryAllChildren(Set<Integer> permissionIds, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return iteratePermission(permissionMapper.queryAllChildren(permissionIds));
    }

    @Override
    public List<Permission> queryLikeName(String name) {
        return iteratePermission(permissionMapper.queryLikeName(name));
    }

    @Override
    public List<Permission> queryLikeName(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return iteratePermission(permissionMapper.queryLikeName(name));
    }

    @Override
    public Integer deleteById(Integer permissionId) {
        return permissionMapper.deleteById(permissionId);
    }

    @Override
    public Integer createPermission(Permission permission) {
        return permissionMapper.createPermission(permission);
    }

    @Override
    public Integer updatePermission(Permission permission) {
        return permissionMapper.updatePermission(permission);
    }
}
