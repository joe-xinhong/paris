package com.commune.paris.service.impl;

import com.commune.paris.dto.AttributeDTO;
import com.commune.paris.dto.GoodsDTO;
import com.commune.paris.entity.*;
import com.commune.paris.mapper.PAttributeValueMapper;
import com.commune.paris.mapper.PCategoryMapper;
import com.commune.paris.mapper.PGoodsMapper;
import com.commune.paris.mapper.PGoodsValMapper;
import com.commune.paris.model.GoodsModel;
import com.commune.paris.service.IAttributeService;
import com.commune.paris.service.IGoodsService;
import com.commune.paris.utils.PageQuery;
import com.commune.paris.utils.Result;
import com.commune.paris.utils.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private PGoodsMapper goodsMapper;
    @Autowired
    private PCategoryMapper categoryMapper;
    @Autowired
    private PGoodsValMapper goodsValMapper;
    @Autowired
    private IAttributeService attributeService;
    @Autowired
    private PAttributeValueMapper attributeValueMapper;
    @Override
    @Transactional
    public Result saveBy(GoodsModel goodsModel) {
        //
        PGoods goods1 = getByCateIdAndName(goodsModel.getCateId(), goodsModel.getName());
        if (goods1!=null){
            return Result.fail("商品信息已经存在");
        }
        PGoods pGoods = new PGoods();
        BeanUtils.copyProperties(goodsModel,pGoods);
        pGoods.setCreateTime(new Date());
        goodsMapper.insertSelective(pGoods);
        // 动态参数处理
        // 静态属性处理
        if (getByModele(goodsModel,pGoods)){
            return Result.success(pGoods);
        }
        return Result.fail("信息有误");
    }

    @Override
    @Transactional
    public Result updateBy(GoodsModel goodsModel) {
        if (goodsModel==null||goodsModel.getId()==null){
            return Result.fail("信息有误");
        }
        PGoods pGoods = new PGoods();
        BeanUtils.copyProperties(goodsModel,pGoods);
        goodsMapper.updateByPrimaryKeySelective(pGoods);
        // 动态参数处理
        // 静态属性处理
        if (getByModele(goodsModel,pGoods)){
            return Result.success(pGoods);
        }
        return Result.fail("信息有误");
    }

    @Override
    public ReturnData<GoodsDTO> getListByPage(String query, PageQuery pageQuery) {
        ReturnData<GoodsDTO> goodsReturnData = new ReturnData<>();
        Integer count = goodsMapper.countAll(query);
        List<PGoods> goodsList = goodsMapper.getGoodsByPage(query,pageQuery);
        List<GoodsDTO> goodsDTOS = goodsList.stream().map(good -> {
            GoodsDTO goodsDTO = getByGoodsDO(good);
            return goodsDTO;
        }).collect(Collectors.toList());
        goodsReturnData.setTotal(count);
        goodsReturnData.setData(goodsDTOS);
        goodsReturnData.setPageNo(pageQuery.getPageNo());
        goodsReturnData.setPageSize(pageQuery.getPageSize());
        return goodsReturnData;
    }


    @Override
    @Transactional
    public Result deleteBy(Integer id) {
        PGoods pGoods = goodsMapper.selectByPrimaryKey(id);
        if (pGoods==null){
            return Result.fail("信息有误");
        }
        PGoodsValExample example = new PGoodsValExample();
        example.createCriteria().andGoodsIdEqualTo(id);
        List<PGoodsVal> pGoodsVals = goodsValMapper.selectByExample(example);
        if (!pGoodsVals.isEmpty()){
            pGoodsVals.forEach(pGoodsVal ->
                goodsValMapper.deleteByPrimaryKey(pGoodsVal.getId())
            );
        }
        goodsMapper.deleteByPrimaryKey(id);
        return Result.success(null);
    }

    @Override
    public Result getOneById(Integer id) {
        GoodsModel goodsModel = new GoodsModel();
        PGoods pGoods = goodsMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(pGoods,goodsModel);
        //动态参数
        List<PAttribute> many1 = attributeService.getDOList(pGoods.getCateId(), "many");
        if (!many1.isEmpty()){
            List<AttributeDTO> manyList = many1.stream().map(pAttribute -> {
                AttributeDTO attributeDTO = new AttributeDTO();
                List<PAttributeValue> values = new ArrayList<>();
                BeanUtils.copyProperties(pAttribute, attributeDTO);
                List<PGoodsVal> manys = getByGoods(pGoods, pAttribute, "many");
                if (!manys.isEmpty()) {
                    manys.forEach(goodval -> {
                        PAttributeValue pAttributeValue = attributeValueMapper.selectByPrimaryKey(goodval.getValId());
                        values.add(pAttributeValue);
                    });
                }
                attributeDTO.setValueList(values);
                return attributeDTO;

            }).collect(Collectors.toList());
            goodsModel.setManies(manyList);
        }
        //静态属性
        List<PAttribute> only1 = attributeService.getDOList(pGoods.getCateId(), "only");
        if (!only1.isEmpty()){
            List<AttributeDTO> onlyList = only1.stream().map(pAttribute -> {
                AttributeDTO attributeDTO = new AttributeDTO();
                BeanUtils.copyProperties(pAttribute, attributeDTO);
                List<PGoodsVal> onlys = getByGoods(pGoods, pAttribute, "only");
                if (!onlys.isEmpty()) {
                    String valString = onlys.get(0).getValString();
                    attributeDTO.setInputValue(valString);
                }
                attributeDTO.setValueList(null);
                return attributeDTO;

            }).collect(Collectors.toList());
            goodsModel.setOnlys(onlyList);
        }
        return Result.success(goodsModel);
    }

    @Override
    public Result getListByCateId(Integer cateId) {
        PGoodsExample example = new PGoodsExample();
        example.createCriteria().andCateIdEqualTo(cateId);
        List<PGoods> goodsList = goodsMapper.selectByExample(example);
        return Result.success(goodsList);
    }

    @Override
    public Result getEasyGoodsById(Integer id) {
        PGoods pGoods = goodsMapper.selectByPrimaryKey(id);
        if (pGoods==null){
            return Result.fail("信息有误");
        }
        GoodsDTO goodsDTO = getByGoodsDO(pGoods);
        return Result.success(goodsDTO);
    }

    /**
     * 获取确定商品的静态/动态数据
     * @param pGoods
     * @param type
     * @return
     */
    private List<PGoodsVal> getByGoods(PGoods pGoods,PAttribute attribute,String type){
        if (pGoods==null|| attribute==null){
            return null;
        }
        //动态参数
        if (type.equals("many")){
            PGoodsValExample example1 = new PGoodsValExample();
            example1.createCriteria().andGoodsIdEqualTo(pGoods.getId()).andValIdNotEqualTo(0).andAttributeIdEqualTo(attribute.getId());
            List<PGoodsVal> pGoodsVals1 = goodsValMapper.selectByExample(example1);
            return pGoodsVals1;
        }
        if (type.equals("only")){
            PGoodsValExample example2 = new PGoodsValExample();
            example2.createCriteria().andGoodsIdEqualTo(pGoods.getId()).andValIdEqualTo(0).andAttributeIdEqualTo(attribute.getId());
            List<PGoodsVal> pGoodsVals2 = goodsValMapper.selectByExample(example2);
            return pGoodsVals2;
        }
        return null;

    }

    /**
     * 根据分类id与商品名称查询是否存在
     * @param cateId
     * @param name
     * @return
     */
    private PGoods getByCateIdAndName(Integer cateId, String name){
        PGoodsExample example = new PGoodsExample();
        example.createCriteria().andCateIdEqualTo(cateId).andNameEqualTo(name);
        List<PGoods> goods = goodsMapper.selectByExample(example);
        if (goods.isEmpty()){
            return null;
        }
        return goods.get(0);
    }

    /**
     * DO——>DTO
     * @param goods
     * @return
     */
    private GoodsDTO getByGoodsDO(PGoods goods){
        if (goods==null){
            return null;
        }
        GoodsDTO goodsDTO = new GoodsDTO();
        BeanUtils.copyProperties(goods,goodsDTO);
        PCategory category = getByCateId(goods.getCateId());
        if (category!=null){
            goodsDTO.setCateName(category.getName());
        }
        return goodsDTO;
    }

    /**
     * 根据分类id查询对象
     * @param cateId
     * @return
     */
    private PCategory getByCateId(Integer cateId){
        PCategory pCategory = categoryMapper.selectByPrimaryKey(cateId);
        return pCategory;
    }

    /**
     * 处理商品动态参数及静态属性
     * @param goodsModel
     * @return
     */
    private boolean getByModele(GoodsModel goodsModel,PGoods pGoods){
        if (goodsModel==null || pGoods.getId()==null){
            return false;
        }
        //删除该商品所有静态属性及动态参数输入值
        PGoodsValExample example = new PGoodsValExample();
        example.createCriteria().andGoodsIdEqualTo(pGoods.getId());
        List<PGoodsVal> goodsVals = goodsValMapper.selectByExample(example);
        if (!goodsVals.isEmpty()){
            goodsVals.forEach(pGoodsVal ->
                goodsValMapper.deleteByPrimaryKey(pGoodsVal.getId())
            );
        }

        //动态参数选值
        List<AttributeDTO> manies = goodsModel.getManies();
        if (manies!=null && manies.size()>0){
            manies.forEach(item ->{
                item.getValueList().forEach(item1 ->{
                    PGoodsVal val = new PGoodsVal();
                    val.setGoodsId(pGoods.getId());
                    val.setAttributeId(item.getId());
                    val.setValId(item1.getId());
                    val.setValString("");
                    goodsValMapper.insert(val);
                });

            });
        }
        //静态属性
        List<AttributeDTO> onlys = goodsModel.getOnlys();
        if (onlys!=null && onlys.size()>0){
            onlys.forEach(item ->{
                PGoodsVal val = new PGoodsVal();
                val.setGoodsId(pGoods.getId());
                val.setAttributeId(item.getId());
                val.setValId(0);
                val.setValString(item.getInputValue());
                goodsValMapper.insert(val);
            });
        }
        return true;
    }
}
