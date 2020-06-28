package com.commune.paris.mapper;

import com.commune.paris.entity.PGoods;
import com.commune.paris.entity.PGoodsVal;
import com.commune.paris.entity.PGoodsValExample;
import java.util.List;

import com.commune.paris.utils.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PGoodsValMapper {
    long countByExample(PGoodsValExample example);

    int deleteByExample(PGoodsValExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PGoodsVal record);

    int insertSelective(PGoodsVal record);

    List<PGoodsVal> selectByExample(PGoodsValExample example);

    PGoodsVal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PGoodsVal record, @Param("example") PGoodsValExample example);

    int updateByExample(@Param("record") PGoodsVal record, @Param("example") PGoodsValExample example);

    int updateByPrimaryKeySelective(PGoodsVal record);

    int updateByPrimaryKey(PGoodsVal record);

}