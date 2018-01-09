package com.boom.service;

import com.boom.domain.SpecialFileResource;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2018/1/9
 * @Time 下午8:37
 * @Description 文件资源服务层操作接口定义
 */
public interface IFileResourceService {

    /**
     *
     * @param id
     * @return {@link SpecialFileResource}
     */
    SpecialFileResource queryById(Integer id);

    /**
     *
     * @param ids
     * @return {@link List <SpecialFileResource>}
     */
    List<SpecialFileResource> queryByIds(Set<Integer> ids);

    /**
     *
     * @param companyId
     * @param fileName 文件名称
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryLikeByName(Integer companyId,String fileName);

    /**
     *
     * @param companyId 公司唯一标识ID
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByCompanyId(Integer companyId);

    /**
     *
     * @param companyId
     * @param modifyDate 文件最近修改时间
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByModifyDate(Integer companyId,Date modifyDate);

    /**
     *
     * @param companyId
     * @param uploadDate 文件上传时间
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByUploadDate(Integer companyId,Date uploadDate);

    /**
     *
     * @param companyId
     * @param extension 文件扩展名
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByExtension(Integer companyId,String extension);

    /**
     *
     * @param specialFileResource
     * @return {@link Integer}
     */
    Integer insert(SpecialFileResource specialFileResource);

    /**
     * 插入非空属性字段
     * @param specialFileResource
     * @return {@link Integer}
     */
    Integer inserSelective(SpecialFileResource specialFileResource);

    /**
     *
     * @param specialFileResource
     * @return {@link Integer}
     */
    Integer update(SpecialFileResource specialFileResource);

    /**
     * 更新非空属性字段
     * @param specialFileResource
     * @return {@link Integer}
     */
    Integer updateSelective(SpecialFileResource specialFileResource);

    /**
     *
     * @param id
     * @return {@link Integer}
     */
    Integer delete(Integer id);

    /**
     *
     * @param ids
     * @return {@link Integer}
     */
    Integer deleteBatch(Set<Integer> ids);
}
