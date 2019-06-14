package com.qf.v12_web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.TProductType;
import com.qf.v12.api.IProductTypeService;
import com.qf.v12.jopo.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductTypeController {
    @Reference
    private IProductTypeService service;

    @RequestMapping("getType/{id}")
    @ResponseBody
    public ResultBean getType(@PathVariable Long id) {
        List<TProductType> byPid = service.getByPid(id);
        if(byPid!=null){
            ResultBean result = new ResultBean(200, byPid);
            return result;
        }else{
            ResultBean result = new ResultBean(404, byPid);
            return result;
        }

    }

}
