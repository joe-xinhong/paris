package com.commune.paris.service;

import com.commune.paris.dto.GoodsDTO;
import com.commune.paris.entity.PGoods;
import com.commune.paris.model.GoodsModel;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;

public interface IGoodsService {

    Result saveBy(GoodsModel goodsModel);

    ReturnData<GoodsDTO> getListByPage(String query, PageQuery pageQuery);

    Result updateBy(GoodsModel goodsModel);

    Result deleteBy(Integer id);

    Result getOneById(Integer id);

    Result getListByCateId(Integer cateId);

    Result getEasyGoodsById(Integer id);
}
