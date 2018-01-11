package com.boom.controller.json;

import com.alibaba.fastjson.JSON;
import com.boom.controller.vo.ResultVo;
import com.boom.domain.SpecialFileResource;
import com.boom.service.IFileResourceService;
import com.summer.base.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2018/1/9
 * @Time 下午9:55
 * @Description 文件资源控制层操作
 */
@RestController
@RequestMapping("/file")
public class FileResourceController {

    private static final Logger logger = LoggerFactory.getLogger(FileResourceController.class);
    @Autowired
    private IFileResourceService fileResourceService;

    @GetMapping("/query.json/{id}")
    public ResultVo getById(@PathVariable Integer id) {
        logger.info("Controller layer:查询单个文件信息============>FileResourceController.queryById({})",id);

        SpecialFileResource specialFileResource = fileResourceService.queryById(id);
        if (ObjectUtils.isNotNull(specialFileResource)) {
            return ResultVo.success(specialFileResource);
        }

        return ResultVo.fail("查询文件信息失败");
    }

//    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/lists.json/{companyId}")
    public ResultVo getByCompanyId(@PathVariable Integer companyId,HttpServletResponse response) {
        logger.info("Controller layer:查询公司所有文件信息============>FileResourceController.getByCompanyId({})",companyId);

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Method","POST,GET");
        List<SpecialFileResource> specialFileResources = fileResourceService.queryByCompanyId(companyId);
        if (ObjectUtils.isNotEmpty(specialFileResources)) {
            return ResultVo.success(specialFileResources);
        }

        return ResultVo.fail("查询公司文件信息失败");
    }

    @PostMapping("/upload.json")
    public ResultVo upload(MultipartFile file) {
        logger.info("Controller layer:上传文件信息============>FileResourceController.upload({})", JSON.toJSONString(file,true));


        return ResultVo.fail("上传文件失败");
    }

    @GetMapping("/download/{fileId}")
    public ResultVo download(@PathVariable Integer fileId, HttpServletResponse response) {
        logger.info("Controller layer:下载文件============>FileResourceController.download({})", fileId);

        return ResultVo.fail("下载文件失败");
    }
}
