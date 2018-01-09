package com.boom.service.impl;

import com.boom.dao.FileResourceMapper;
import com.boom.domain.SpecialFileResource;
import com.boom.service.IFileResourceService;
import com.google.common.collect.Lists;
import com.summer.base.utils.ObjectUtils;
import com.summer.base.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2018/1/9
 * @Time 下午8:38
 * @Description {@link IFileResourceService}实现类
 */
@Service("fileResourceService")
@Transactional
public class FileResourceServiceImpl implements IFileResourceService {

    private static final Logger logger = LoggerFactory.getLogger(FileResourceServiceImpl.class);
    @Autowired
    private FileResourceMapper fileResourceMapper;

    @Override
    public SpecialFileResource queryById(Integer id) {
        logger.info("Service layer:查询单个文件资源信息==========>FileResourceServiceImpl.queryById()");

        SpecialFileResource specialFileResource = null;
        if (ObjectUtils.isNotNull(id)) {
            specialFileResource = fileResourceMapper.queryById(id);
        }

        return specialFileResource;
    }

    @Override
    public List<SpecialFileResource> queryByIds(Set<Integer> ids) {
        logger.info("Service layer:批量查询文件资源信息==========>FileResourceServiceImpl.queryByIds()");

        List<SpecialFileResource> specialFileResources = Lists.newArrayList();
        if (ObjectUtils.isNotEmpty(ids)) {
            specialFileResources = fileResourceMapper.queryByIds(ids);
        }
        return specialFileResources;
    }

    @Override
    public List<SpecialFileResource> queryLikeByName(Integer companyId,String fileName) {
        logger.info("Service layer:通过文件名查询文件资源信息==========>FileResourceServiceImpl.queryLikeByName()");

        List<SpecialFileResource> specialFileResources = Lists.newArrayList();
        if (StringUtils.isNotEmpty(fileName) && ObjectUtils.isNotNull(companyId)) {
            specialFileResources = fileResourceMapper.queryLikeByName(companyId,fileName);
        }
        return specialFileResources;
    }

    @Override
    public List<SpecialFileResource> queryByCompanyId(Integer companyId) {
        logger.info("Service layer:查询某公司拥有的文件资源信息==========>FileResourceServiceImpl.queryByCompanyId()");

        List<SpecialFileResource> specialFileResources = Lists.newArrayList();
        if (ObjectUtils.isNotNull(companyId)) {
            specialFileResources = fileResourceMapper.queryByCompanyId(companyId);
        }
        return specialFileResources;
    }

    @Override
    public List<SpecialFileResource> queryByModifyDate(Integer companyId,Date modifyDate) {
        logger.info("Service layer:查询某个时间修改的文件资源信息==========>FileResourceServiceImpl.queryByModifyDate()");

        List<SpecialFileResource> specialFileResources = Lists.newArrayList();
        if (ObjectUtils.isNotNull(companyId)) {
            if (ObjectUtils.isNull(modifyDate)) {
                modifyDate = new Date();
            }
            specialFileResources = fileResourceMapper.queryByModifyDate(companyId,modifyDate);
        }
        return specialFileResources;
    }

    @Override
    public List<SpecialFileResource> queryByUploadDate(Integer companyId,Date uploadDate) {
        logger.info("Service layer:查询某个上传时间的文件资源信息==========>FileResourceServiceImpl.queryByUploadDate()");

        List<SpecialFileResource> specialFileResources = Lists.newArrayList();
        if (ObjectUtils.isNotNull(companyId)) {
            if (ObjectUtils.isNull(uploadDate)) {
                uploadDate = new Date();
            }
            specialFileResources = fileResourceMapper.queryByUploadDate(companyId,uploadDate);
        }
        return specialFileResources;
    }

    @Override
    public List<SpecialFileResource> queryByExtension(Integer companyId,String extension) {
        logger.info("Service layer:根据文件扩展名查询文件资源信息==========>FileResourceServiceImpl.queryByExtension()");

        List<SpecialFileResource> specialFileResources = Lists.newArrayList();
        if (ObjectUtils.isNotNull(companyId) && StringUtils.isNotEmpty(extension)) {
            specialFileResources = fileResourceMapper.queryByExtension(companyId,extension);
        }
        return specialFileResources;
    }

    @Override
    public Integer insert(SpecialFileResource specialFileResource) {
        logger.info("Service layer:添加文件资源信息===============>FileResourceServiceImpl.insert()");

        Integer result = null;
        if (ObjectUtils.isNotNull(specialFileResource)) {
            result = fileResourceMapper.insert(specialFileResource);
        }
        return result;
    }

    @Override
    public Integer inserSelective(SpecialFileResource specialFileResource) {
        logger.info("Service layer:添加文件资源信息===============>FileResourceServiceImpl.insert()");

        Integer result = null;
        if (ObjectUtils.isNotNull(specialFileResource)) {
            result = fileResourceMapper.insertSelective(specialFileResource);
        }
        return result;
    }

    @Override
    public Integer update(SpecialFileResource specialFileResource) {
        logger.info("Service layer:更新文件资源信息===============>FileResourceServiceImpl.update()");

        Integer result = null;
        if (ObjectUtils.isNotNull(specialFileResource)) {
            result = fileResourceMapper.update(specialFileResource);
        }
        return result;
    }

    @Override
    public Integer updateSelective(SpecialFileResource specialFileResource) {
        logger.info("Service layer:更新文件资源信息===============>FileResourceServiceImpl.update()");

        Integer result = null;
        if (ObjectUtils.isNotNull(specialFileResource)) {
            result = fileResourceMapper.updateSelective(specialFileResource);
        }
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        logger.info("Service layer:删除单个文件资源信息===============>FileResourceServiceImpl.delete()");

        Integer result = null;
        if (ObjectUtils.isNotNull(id)) {
            result = fileResourceMapper.delete(id);
        }
        return result;
    }

    @Override
    public Integer deleteBatch(Set<Integer> ids) {
        logger.info("Service layer:批量删除文件资源信息===============>FileResourceServiceImpl.deleteBatch()");

        Integer result = null;
        if (ObjectUtils.isNotEmpty(ids)) {
            result = fileResourceMapper.deleteBatch(ids);
        }
        return result;
    }
}
