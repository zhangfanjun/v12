package com.qf.v12_web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.qf.entity.TProduct;
import com.qf.entity.TProductType;
import com.qf.v12.api.IProductService;
import com.qf.v12.entity.TProductVO;
import com.qf.v12.jopo.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Reference
    private IProductService service;

    @RequestMapping("page/{pageIndex}/{pageSize}")
    public String getList(@PathVariable int pageIndex, @PathVariable int pageSize, ModelMap map) {
        PageInfo<TProduct> page = service.getPage(pageIndex, pageSize);
        map.put("page", page);
        return "/product/list";
    }

    @PostMapping("add")
    public String add(TProductVO vo) {
        Long productId = service.addProductVO(vo);
        return "redirect:/product/page/1/2";
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    public ResultBean del(@PathVariable long id) {
        int i = service.deleteByPrimaryKey(id);
        if (i > 0) {
            ResultBean r = new ResultBean(200, "成功删除");
            return r;
        } else {
            ResultBean r = new ResultBean(404, "删除失败");
            return r;
        }
    }

    @PostMapping("delAll")
    @ResponseBody
    public ResultBean delAll(@RequestParam(value = "list") List<Long> list) {
        System.out.println(list);
        int i = service.bathDel(list);
        if (i > 0) {
            ResultBean r = new ResultBean(200, "成功删除");
            return r;
        } else {
            ResultBean r = new ResultBean(404, "删除失败");
            return r;
        }
    }

    @RequestMapping("getById/{id}")
    public TProductType getType(@PathVariable Long pId) {

        return null;
    }

}
