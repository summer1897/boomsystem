package com.boom.rbac.controller;

import com.boom.rbac.controller.vo.ResultVo;
import com.boom.rbac.domain.Role;
import com.boom.rbac.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/13 下午9:53
 * @Description 角色操作控制层
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/list.json/{name}",method = RequestMethod.GET)
    @ResponseBody
    public Role list(@PathVariable("name") String name) {
        log.info("根据角色名称查询角色对象===>RoleController.list()");
        return roleService.queryByName(name);
    }

    @RequestMapping(value = "/lists.json",method = RequestMethod.GET)
    @ResponseBody
    public List<Role> lists() {
        log.info("查询所有角色对象===>RoleController.lists()");
        return roleService.queryAll();
    }

    @RequestMapping(value = "/listsPage.json/{pageNum}/{pageSize}",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo listsByPagination(@PathVariable("pageNum") Integer pageNum,
                                        @PathVariable("pageSize") Integer pageSize) {
        log.info("分页查询角色对象,pageNum={},pageSize={}===>RoleController.listsByPagination()",pageNum,pageSize);

        ResultVo<List<Role>> resultVo = new ResultVo<>();
        resultVo.setCode(1);
        resultVo.setMsg("");
        resultVo.setPageNum(pageNum);
        resultVo.setPageSize(pageSize);
        resultVo.setData(roleService.queryAllByPagination(pageNum,pageSize));

        return resultVo;
    }

}
