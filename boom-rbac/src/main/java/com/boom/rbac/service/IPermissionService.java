package com.boom.rbac.service;

import com.boom.rbac.domain.Permission;

import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/14 下午11:04
 * @Description 权限Service操作接口定义
 */
public interface IPermissionService {

    /**
     * 根据权限ID查询所有权限
     * @param permissionId
     * @return Permission
     */
    Permission queryById(Integer permissionId);

    /**
     * 获取所有权限
     * @return List<Permission>
     */
    List<Permission> queryAll();

    /**
     * 分页获取所有权限
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    List<Permission> queryAllAndPagination(Integer pageNum,Integer pageSize);

    /**
     * 根据多个权限ID查询其对应的所有权限
     * @param permissionIds
     * @return List<Permission>
     */
    List<Permission> queryByIds(Set<Integer> permissionIds);

    /**
     * 根据多个权限ID查询其对应的所有权限,并分页返回
     * @param permissionIds
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    List<Permission> queryByIdsAndPagination(Set<Integer> permissionIds,Integer pageNum,Integer pageSize);

    /**
     * 查询当前权限的的所有子权限
     * @param permissionId
     * @return List<Permission>
     */
    List<Permission> queryChildren(Integer permissionId);

    /**
     * 查询当前权限的的所有子权限，并分页返回
     * @param permissionId
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    List<Permission> queryChildren(Integer permissionId,Integer pageNum,Integer pageSize);

    /**
     * 根据多个权限ID查询其对应的所有子权限
     * @param permissionIds
     * @return List<Permission>
     */
    List<Permission> queryAllChildren(Set<Integer> permissionIds);

    /**
     * 根据多个权限ID查询其对应的所有子权限,分页返回
     * @param permissionIds
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    List<Permission> queryAllChildren(Set<Integer> permissionIds,Integer pageNum,Integer pageSize);

    /**
     * 根据权限名称模糊查询权限
     * @param name
     * @return List<Permission>
     */
    List<Permission> queryLikeName(String name);

    /**
     * 根据权限名称模糊查询权限,分页返回
     * @param name
     * @param pageNum 页号
     * @param pageSize 分页数
     * @return List<Permission>
     */
    List<Permission> queryLikeName(String name,Integer pageNum,Integer pageSize);

    /**
     * 删除权限
     * @param permissionId
     * @return Integer,返回删除权限数量
     */
    Integer deleteById(Integer permissionId);

    /**
     * 创建权限
     * @param permission
     * @return Integer,返回添加权限数
     */
    Integer createPermission(Permission permission);

    /**
     * 更新权限信息
     * @param permission
     * @return Integer,返回更新数据条数
     */
    Integer updatePermission(Permission permission);

}
