package com.boom.dao;

import com.boom.domain.SpecialFileResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2018/1/9
 * @Time 下午8:27
 * @Description 文件资源数据访问层操作接口定义
 */
@Repository
public interface FileResourceMapper {

    /**
     *
     * @param id
     * @return {@link SpecialFileResource}
     */
    SpecialFileResource queryById(@Param("id") Integer id);

    /**
     *
     * @param ids
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByIds(@Param("ids") Set<Integer> ids);

    /**
     *
     * @param fileName 文件名称
     * @param companyId
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryLikeByName(@Param("companyId") Integer companyId,
                                              @Param("fileName") String fileName);

    /**
     *
     * @param companyId 公司唯一标识ID
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByCompanyId(@Param("companyId") Integer companyId);

    /**
     *
     * @param companyId
     * @param modifyDate 文件最近修改时间
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByModifyDate(@Param("companyId") Integer companyId,
                                                @Param("modifyDate") Date modifyDate);

    /**
     *
     * @param companyId
     * @param uploadDate 文件上传时间
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByUploadDate(@Param("companyId") Integer companyId,
                                                @Param("uploadDate") Date uploadDate);

    /**
     *
     * @param companyId
     * @param extension 文件扩展名
     * @return {@link List<SpecialFileResource>}
     */
    List<SpecialFileResource> queryByExtension(@Param("companyId") Integer companyId,
                                               @Param("extension") String extension);

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
    Integer insertSelective(SpecialFileResource specialFileResource);

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
    Integer delete(@Param("id") Integer id);

    /**
     *
     * @param ids
     * @return {@link Integer}
     */
    Integer deleteBatch(@Param("ids") Set<Integer> ids);

}
