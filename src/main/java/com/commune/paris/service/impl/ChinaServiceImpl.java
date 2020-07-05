package com.commune.paris.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.commune.paris.entity.PChina;
import com.commune.paris.entity.PChinaExample;
import com.commune.paris.mapper.PChinaMapper;
import com.commune.paris.service.IChinaService;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ChinaServiceImpl implements IChinaService {
    @Autowired
    private PChinaMapper chinaMapper;

    @Override
    public Result getAllTree() {
        List<PChina> list = getList();
        if (list.isEmpty()){
            return Result.success(null);
        }
        JSONArray array = new JSONArray();
        //TreeUtils.setChinaTree(0,list,array);
        setChina(0,list,array);
        return Result.success(array);
    }


    /**
     * 获取全部城市集合list
     * @return
     */
    private List<PChina> getList(){
        List<PChina> chinas = chinaMapper.selectByExample(new PChinaExample());
        return chinas;
    }


    public boolean getChinaBool(Integer pid, List<PChina> chinaList){
        if (chinaList.isEmpty()){
            return false;
        }
        List<PChina> newList = new ArrayList<>();
        chinaList.forEach(china->{
            if (china.getpId().equals(pid)){
                newList.add(china);
            }
        });
        if (newList.size()>0){
            return true;
        }
        return false;
    }

    private void setChina(Integer pid, List<PChina> chinaList, JSONArray array){
        for (PChina china: chinaList){
            if (china.getpId().equals(pid)){
                String string = JSONObject.toJSONString(china);
                JSONObject parent = (JSONObject)JSONObject.parse(string);
                array.add(parent);
                if (getChinaBool(china.getId(),chinaList)){
                    JSONArray child = new JSONArray();
                    parent.put("children",child);
                    setChina(china.getId(),chinaList,child);
                }
            }
        }
    }

}
