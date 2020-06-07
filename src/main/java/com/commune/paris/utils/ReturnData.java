package com.commune.paris.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReturnData<T> {
    //数据集合
    private List<T> data = new ArrayList<T>();
    //数据总条数
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private Integer total = 0;
}
