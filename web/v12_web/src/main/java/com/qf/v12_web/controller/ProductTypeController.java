package com.qf.v12_web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.v12.api.IProductService;
import com.qf.v12.api.IProductTypeService;
import com.qf.v12.jopo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("productType")
public class ProductTypeController {
    @Reference
    private IProductTypeService service;

    @RequestMapping("getType/{id}")
    public ResultBean getType(@PathVariable Long id) {


        return null;
    }
}
