package com.boom.rbac.controller.vo;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/13 下午9:59
 * @Description Controller层返回结果用的实体对象
 */
public class ResultVo<T> {

    /**
     * 状态码,1表示成功，-1表示失败
     */
    private int status;
    /**
     * 反馈信息
     */
    private String msg;

    /**
     * 表示当前分页起始位置
     */
    private int pageNum;

    /**
     * 当前页面数据量
     */
    private int pageSize;

    private T data;

    public ResultVo() {
    }

    public ResultVo(int status, String msg, int pageNum, int pageSize, T data) {
        this.status = status;
        this.msg = msg;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
