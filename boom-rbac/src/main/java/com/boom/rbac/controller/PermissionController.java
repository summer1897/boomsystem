package com.boom.rbac.controller;

import com.boom.rbac.controller.vo.ResultVo;
import com.boom.rbac.domain.Permission;
import com.boom.rbac.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/14 下午11:54
 * @Description 权限控制层操作
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "/lists.json",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo listAll() {
        List<Permission> permissions = permissionService.queryAll();
        ResultVo<List<Permission>> resultVo = new ResultVo<>(200,"",permissions);
        return resultVo;
    }

    @RequestMapping(value = "/lists.json/{pageNum}/{pageSize}",method = RequestMethod.GET)
    @ResponseBody
    public ResultVo listAllAndPagination(@PathVariable("pageNum") Integer pageNum,
                                         @PathVariable("pageSize") Integer pageSize) {
        List<Permission> permissions = permissionService.queryAllAndPagination(pageNum,pageSize);
        ResultVo<List<Permission>> resultVo = new ResultVo<>(200,"",permissions);
        return resultVo;
    }
}
