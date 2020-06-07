package com.commune.paris.utils;

import lombok.Data;
/**
* @Description:    分页处理
* @Author:         Joe
* @CreateDate:     2020/6/3 16:47
*/
@Data
public class PageQuery {

    private Integer pageNo = 1;
    private Integer pageSize = 10;

    /**
     * 偏移量（每页显示数量=偏移量 ：1到10条数据limit 0,10;第二页的十条：从11到20条数据limit 10,10）
     */
    private Integer offset;

    public Integer getOffset(){
        return (pageNo - 1) *10;
    }
}
