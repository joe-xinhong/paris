package com.commune.paris.mapper;

import com.commune.paris.entity.POrder;
import com.commune.paris.entity.POrderExample;
import java.util.List;

import com.commune.paris.utils.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface POrderMapper {
    long countByExample(POrderExample example);

    int deleteByExample(POrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(POrder record);

    int insertSelective(POrder record);

    List<POrder> selectByExample(POrderExample example);

    POrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") POrder record, @Param("example") POrderExample example);

    int updateByExample(@Param("record") POrder record, @Param("example") POrderExample example);

    int updateByPrimaryKeySelective(POrder record);

    int updateByPrimaryKey(POrder record);

    Integer countOrderAll(@Param("userId")Integer userId);

    List<POrder> getOrderByPage(@Param("userId")Integer userId, @Param("page")PageQuery page);

    int deleteByOrderId(@Param("orderId")String orderId);

    List<POrder> getToday();

    List<POrder> getMonth();
}