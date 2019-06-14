package com.qf.v12.api;

import com.alibaba.dubbo.rpc.filter.TpsLimitFilter;
import com.qf.entity.TProductType;
import com.qf.v12.base.IBaseService;

import java.util.List;

public interface IProductTypeService extends IBaseService<TProductType> {
    List<TProductType> getByPid(Long id);
}
