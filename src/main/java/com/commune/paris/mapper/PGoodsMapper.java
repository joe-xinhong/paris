package com.commune.paris.mapper;

import com.commune.paris.entity.PGoods;
import com.commune.paris.entity.PGoodsExample;
import java.util.List;

import com.commune.paris.utils.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PGoodsMapper {
    long countByExample(PGoodsExample example);

    int deleteByExample(PGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PGoods record);

    int insertSelective(PGoods record);

    List<PGoods> selectByExample(PGoodsExample example);

    PGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PGoods record, @Param("example") PGoodsExample example);

    int updateByExample(@Param("record") PGoods record, @Param("example") PGoodsExample example);

    int updateByPrimaryKeySelective(PGoods record);

    int updateByPrimaryKey(PGoods record);

    Integer countAll(@Param("name")String name);

    List<PGoods> getGoodsByPage(@Param("name")String name, @Param("page")PageQuery page);
}