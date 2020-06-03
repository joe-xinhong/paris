package com.commune.paris.utils;

import lombok.Data;
@Data
public class PageQuery {

    private Integer pageNo = 1;
    private Integer pageSize = 10;
    /**
     * 偏移量（第一页的十条：1到10条数据limit 1,10;第二页的十条：从11到20条数据limit 11,10）
     */
    private Integer offset;

    public Integer getOffset(){
        return (pageNo - 1) *10;
    }
}
