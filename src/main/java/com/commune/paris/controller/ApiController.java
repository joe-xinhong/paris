package com.commune.paris.controller;

import com.commune.paris.dto.IndexTableDTO;
import com.commune.paris.dto.IndexTagDTO;
import com.commune.paris.entity.*;
import com.commune.paris.mapper.PGoodsMapper;
import com.commune.paris.mapper.PUserMapper;
import com.commune.paris.service.IOrderService;
import com.commune.paris.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(value = "/api",name = "/总接口")
public class ApiController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private PUserMapper userMapper;
    @Autowired
    private PGoodsMapper goodsMapper;
    @RequestMapping(value = "/getTable",method = RequestMethod.GET,name = "获取后台主页列表接口")
    public Result getTable(){
        List<POrder> listByToday = orderService.getListByToday();
        List<POrder> listByMonth = orderService.getListByMonth();
        List<POrder> listAll = orderService.getListAll();
        if (listByToday!=null && listByMonth!=null && listAll!=null){
            List<IndexTableDTO> list = getList(listByToday, listByMonth, listAll);
            return Result.success(list);
        }
        return Result.success(null);
    }

    @RequestMapping(value = "/getTag",method = RequestMethod.GET,name = "获取后台主页标签接口")
    public Result getTag(){
        List<POrder> listByToday = orderService.getListByToday();
        List<POrder> listByMonth = orderService.getListByMonth();
        List<POrder> listAll = orderService.getListAll();
        if (listByToday!=null && listByMonth!=null && listAll!=null){
            List<IndexTagDTO> tagDTOS = getTagList(listByToday, listByMonth, listAll);
            return Result.success(tagDTOS);
        }
        return Result.success(null);
    }

    @RequestMapping(value = "/getGoodsCount",method = RequestMethod.GET,name = "获取商品请求统计接口")
    public Result getGoodsCount(){
        Result result = orderService.getGoodsCount();
        return result;
    }

    private List<IndexTagDTO> getTagList(List<POrder> listByToday, List<POrder> listByMonth, List<POrder> listAll){
        List<IndexTagDTO> tagDTOS = new ArrayList<>();

        IndexTagDTO indexTagDTO1 = new IndexTagDTO();
        indexTagDTO1.setTitle("今日订单数");
        indexTagDTO1.setSum(listByToday.size());
        indexTagDTO1.setIconCss("success");
        indexTagDTO1.setTagColor("#FFB6C1");
        tagDTOS.add(indexTagDTO1);

        IndexTagDTO indexTagDTO2 = new IndexTagDTO();
        indexTagDTO2.setTitle("本月订单数");
        indexTagDTO2.setSum(listByMonth.size());
        indexTagDTO2.setIconCss("s-platform");
        indexTagDTO2.setTagColor("#DDA0DD");
        tagDTOS.add(indexTagDTO2);

        IndexTagDTO indexTagDTO3 = new IndexTagDTO();
        indexTagDTO3.setTitle("总计订单数");
        indexTagDTO3.setSum(listAll.size());
        indexTagDTO3.setIconCss("s-release");
        indexTagDTO3.setTagColor("#6495ED");
        tagDTOS.add(indexTagDTO3);

        IndexTagDTO indexTagDTO6 = new IndexTagDTO();
        indexTagDTO6.setTitle("总活跃人数");
        List<Integer> list6 = getList(listAll);
        if (list6.isEmpty()){
            indexTagDTO6.setSum(0);
        }
        indexTagDTO6.setSum(list6.size());
        indexTagDTO6.setIconCss("platform-eleme");
        indexTagDTO6.setTagColor("#FFD700");
        tagDTOS.add(indexTagDTO6);

        IndexTagDTO indexTagDTO4 = new IndexTagDTO();
        indexTagDTO4.setTitle("总人数");
        List<PUser> users = userMapper.selectByExample(new PUserExample());
        if (users.isEmpty()){
            indexTagDTO4.setSum(0);
        }
        indexTagDTO4.setSum(users.size());
        indexTagDTO4.setIconCss("s-shop");
        indexTagDTO4.setTagColor("#00CED1");
        tagDTOS.add(indexTagDTO4);

        IndexTagDTO indexTagDTO5 = new IndexTagDTO();
        indexTagDTO5.setTitle("总商品数");
        List<PGoods> goodsList = goodsMapper.selectByExample(new PGoodsExample());
        if (goodsList.isEmpty()){
            indexTagDTO5.setSum(0);
        }
        indexTagDTO5.setSum(goodsList.size());
        indexTagDTO5.setIconCss("s-promotion");
        indexTagDTO5.setTagColor("#ffb980");
        tagDTOS.add(indexTagDTO5);

        return tagDTOS;
    }




    private List<IndexTableDTO> getList(List<POrder> listByToday, List<POrder> listByMonth, List<POrder> listAll){
        List<IndexTableDTO> tableDTOS = new ArrayList<>();

        IndexTableDTO indexTableDTO1 = new IndexTableDTO();
        indexTableDTO1.setTitle("订单数据");
        indexTableDTO1.setTodayCount(listByToday.size());
        indexTableDTO1.setMonthCount(listByMonth.size());
        indexTableDTO1.setCount(listAll.size());
        tableDTOS.add(indexTableDTO1);

        IndexTableDTO indexTableDTO2 = new IndexTableDTO();
        indexTableDTO2.setTitle("用户活跃");
        List<Integer> todayList = getList(listByToday);
        if (todayList!=null){
            indexTableDTO2.setTodayCount(todayList.size());
        }else {
            indexTableDTO2.setTodayCount(0);
        }
        List<Integer> monthList = getList(listByMonth);
        if (monthList!=null){
            indexTableDTO2.setMonthCount(monthList.size());
        }else {
            indexTableDTO2.setMonthCount(0);
        }
        List<Integer> allList = getList(listAll);
        if (allList!=null){
            indexTableDTO2.setCount(allList.size());
        }else {
            indexTableDTO2.setCount(0);
        }
        tableDTOS.add(indexTableDTO2);

        return tableDTOS;
    }

    private List<Integer> getList(List<POrder> list){
        if (list.isEmpty()){
            return null;
        }
        List<Integer> integers = list.stream().map(pOrder -> {
            Integer uid = pOrder.getUserId();
            return uid;
        }).collect(Collectors.toList());
        if (integers.isEmpty()){
            return null;
        }
        HashSet h = new HashSet(integers);
        integers.clear();
        integers.addAll(h);
        return integers;
    }

}
