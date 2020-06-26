package com.commune.paris.service.impl;

import com.commune.paris.dto.AttributeDTO;
import com.commune.paris.entity.PAttribute;
import com.commune.paris.entity.PAttributeExample;
import com.commune.paris.entity.PAttributeValue;
import com.commune.paris.entity.PAttributeValueExample;
import com.commune.paris.mapper.PAttributeMapper;
import com.commune.paris.mapper.PAttributeValueMapper;
import com.commune.paris.service.IAttributeService;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AttributeServiceImpl implements IAttributeService {

    @Autowired
    private PAttributeMapper attributeMapper;
    @Autowired
    private PAttributeValueMapper valueMapper;


    @Override
    @Transactional
    public Result getList(Integer cate_id, String sel) {
        PAttributeExample example = new PAttributeExample();
        example.createCriteria().andCateIdEqualTo(cate_id).andSelEqualTo(sel);
        List<PAttribute> attributes = attributeMapper.selectByExample(example);
        if (!attributes.isEmpty()){
            List<AttributeDTO> DTOs = attributes.stream().map(attribute -> {
                AttributeDTO fromDTO = getFromDo(attribute);
                return fromDTO;
            }).collect(Collectors.toList());
            return Result.success(DTOs);
        }
        return Result.success(null);
    }

    @Override
    @Transactional
    public Result save(PAttribute attribute) {
        PAttribute by = getDOBy(attribute.getCateId(), attribute.getName(), attribute.getSel());
        if (by!=null){
            return Result.fail("参数已经存在");
        }
        if (attribute.getSel().equals("many")){
            attribute.setWrite("list");
        }else {
            attribute.setWrite("manual");
        }
        attributeMapper.insertSelective(attribute);
        return Result.success(attribute);
    }

    @Override
    public Result getOne(Integer cate_id, Integer id, String sel) {
        PAttributeExample example = new PAttributeExample();
        example.createCriteria().andSelEqualTo(sel).andCateIdEqualTo(cate_id).andIdEqualTo(id);
        List<PAttribute> attributes = attributeMapper.selectByExample(example);
        if (attributes.isEmpty()){
            return Result.success(null);
        }
        return Result.success(attributes.get(0));
    }

    @Override
    @Transactional
    public Result UpdateOne(PAttribute attribute) {
        PAttribute doBy = getDOBy(attribute.getCateId(), attribute.getName(), attribute.getSel());
        if (doBy==null){
            attributeMapper.updateByPrimaryKeySelective(attribute);
        }
        PAttribute attribute1 = attributeMapper.selectByPrimaryKey(attribute.getId());
        return Result.success(attribute1);
    }

    @Override
    @Transactional
    public Result delete(Integer cate_id, Integer id) {
        //查询对应的
        PAttribute attribute = attributeMapper.selectByPrimaryKey(id);
        if (attribute==null||attribute.getCateId()!=cate_id){
            return Result.fail("信息有误");
        }
        List<PAttributeValue> values = getListByAId(id);
        if (!values.isEmpty()){
            values.forEach(value ->
                valueMapper.deleteByPrimaryKey(value.getId())
            );
        }
        attributeMapper.deleteByPrimaryKey(id);
        return Result.success(null);
    }

    @Override
    @Transactional
    public Result saveValue(PAttributeValue attributeValue) {
        if (attributeValue==null&&attributeValue.getAttributeId()==null){
            return Result.fail("信息有误");
        }
        PAttribute attribute = attributeMapper.selectByPrimaryKey(attributeValue.getAttributeId());
        if (attribute==null){
            return Result.fail("信息有误");
        }
        PAttributeValue value = getByIdAndValue(attributeValue.getAttributeId(), attributeValue.getAttributeVal());
        if (value!=null){
            return Result.success(value);
        }
        valueMapper.insertSelective(attributeValue);
        return Result.success(attributeValue);
    }

    @Override
    @Transactional
    public Result deleteValue(PAttributeValue attributeValue) {
        if (attributeValue!=null&& attributeValue.getId()!=null){
            int i = valueMapper.deleteByPrimaryKey(attributeValue.getId());
            return Result.success(i);
        }
        return Result.success(null);
    }

    /**
     * 根据aid与val判断是否重复
     * @param aId
     * @param value
     * @return
     */
    private PAttributeValue getByIdAndValue(Integer aId, String value){
        PAttributeValueExample example = new PAttributeValueExample();
        example.createCriteria().andAttributeIdEqualTo(aId).andAttributeValEqualTo(value);
        List<PAttributeValue> values = valueMapper.selectByExample(example);
        if(values.isEmpty()){
            return null;
        }
        return values.get(0);
    }

    /**
     * 根据参数分类ID,名称，属性类别查询是否存在
     * @param cateId
     * @param name
     * @param sel
     * @return
     */
    private PAttribute getDOBy(Integer cateId, String name, String sel){
        PAttributeExample example = new PAttributeExample();
        example.createCriteria().andCateIdEqualTo(cateId).andNameEqualTo(name).andSelEqualTo(sel);
        List<PAttribute> attributes = attributeMapper.selectByExample(example);
        if (attributes.isEmpty()){
            return null;
        }
        return attributes.get(0);
    }

    /**
     * 根据属性id查询属性值集合
     * @param attributeId
     * @return
     */
    private List<PAttributeValue> getListByAId(Integer attributeId){
        PAttributeValueExample example = new PAttributeValueExample();
        example.createCriteria().andAttributeIdEqualTo(attributeId);
        List<PAttributeValue> values = valueMapper.selectByExample(example);
        return values;
    }

    /**
     * 转换DO——>DTO
     * @param attribute
     * @return
     */
    private AttributeDTO getFromDo(PAttribute attribute){
        if (attribute==null){
            return null;
        }
        List<PAttributeValue> values = getListByAId(attribute.getId());
        AttributeDTO attributeDTO = new AttributeDTO();
        BeanUtils.copyProperties(attribute,attributeDTO);
        attributeDTO.setValueList(values);
        return attributeDTO;
    }
}
