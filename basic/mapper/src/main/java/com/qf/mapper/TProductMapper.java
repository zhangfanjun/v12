package com.qf.mapper;

import com.qf.entity.TProduct;
import com.qf.v12.base.IBaseDao;

import java.util.List;

public interface TProductMapper extends IBaseDao<TProduct> {
    int bathDel(List<Long> list);

}