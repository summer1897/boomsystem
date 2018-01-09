package com.boom.domain;

import java.io.Serializable;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2018/1/9
 * @Time 下午8:25
 * @Description 用于特殊用途的文件资源类
 */
public class SpecialFileResource extends SystemFileResource implements Serializable {
    private static final long serialVersionUID = 7860365655007751252L;

    private Integer companyId;

    public SpecialFileResource() {
        super();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
