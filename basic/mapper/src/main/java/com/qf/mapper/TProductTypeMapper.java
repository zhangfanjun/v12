package com.qf.mapper;

import com.qf.entity.TProductType;
import com.qf.v12.base.IBaseDao;

import java.util.List;

public interface TProductTypeMapper extends IBaseDao<TProductType> {
    List<TProductType> getByPid(Long id);
}