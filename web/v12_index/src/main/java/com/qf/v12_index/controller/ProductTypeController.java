package com.qf.v12_index.controller;

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
@RequestMapping("index")
public class ProductTypeController {
    @Reference
    private IProductTypeService service;

    @RequestMapping("getType")
    @ResponseBody
    public List<TProductType> getType() {
        List<TProductType> list = service.getList();

        return list;

    }


}
