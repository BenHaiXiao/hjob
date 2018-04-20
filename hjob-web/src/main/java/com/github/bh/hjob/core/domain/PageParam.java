package com.github.bh.hjob.core.domain;

/**
 * 分页查询参数
 */
public class PageParam<T> {

    private final static int DEFAULT_PAGE_NUMBER = 1;

    private final static int DEFAULT_PAGE_SIZE = 20;

    private Integer pageNumber = DEFAULT_PAGE_NUMBER;  // 查询页码

    private Integer pageSize = DEFAULT_PAGE_SIZE;    // 每页记录数

    protected T args;            // 查询参数

    public PageParam() {
    }

    public PageParam(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber > 0 ? pageNumber : DEFAULT_PAGE_NUMBER;
        this.pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

    public PageParam(Integer pageNumber, Integer pageSize, T args) {
        this.pageNumber = pageNumber > 0 ? pageNumber : DEFAULT_PAGE_NUMBER;
        this.pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
        this.args = args;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public PageParam setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber > 0 ? pageNumber : DEFAULT_PAGE_NUMBER;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageParam setPageSize(Integer pageSize) {
        this.pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
        return this;
    }

    public T getArgs() {
        return args;
    }

    public PageParam setArgs(T args) {
        this.args = args;
        return this;
    }

    /**
     * 获取分页开始游标（limit start,pageSize）
     */
    public Integer getStart() {
        return (pageNumber - 1) * pageSize;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageParam{");
        sb.append("pageNumber=").append(pageNumber);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", args=").append(args);
        sb.append('}');
        return sb.toString();
    }
}
