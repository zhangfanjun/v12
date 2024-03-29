package com.qf.v12_service.product;

import com.qf.entity.TProductType;
import com.qf.mapper.TProductTypeMapper;
import com.qf.v12.api.IProductTypeService;
import com.qf.v12.base.IBaseDao;
import com.qf.v12.base.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductTypeService extends BaseService<TProductType> implements IProductTypeService {
    @Autowired
    private TProductTypeMapper mapper;
    @Override
    public IBaseDao<TProductType> getDao() {
        return mapper;
    }

    @Override
    public List<TProductType> getByPid(Long id) {
        List<TProductType> byPid = mapper.getByPid(id);
        return byPid;
    }
}
