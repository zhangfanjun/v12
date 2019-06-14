package com.qf.v12.api;

import com.github.pagehelper.PageInfo;
import com.qf.entity.TProduct;
import com.qf.mapper.TProductMapper;
import com.qf.v12.base.IBaseService;
import com.qf.v12.entity.TProductVO;

import java.util.List;

public interface IProductService extends IBaseService<TProduct> {
    PageInfo<TProduct> getPage(int pageIndex,int pageSize);
    Long addProductVO(TProductVO tProductVO);
    int bathDel(List<Long> list);
}
