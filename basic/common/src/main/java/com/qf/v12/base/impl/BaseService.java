package com.qf.v12.base.impl;

import com.github.pagehelper.PageHelper;
import com.qf.v12.base.IBaseDao;
import com.qf.v12.base.IBaseService;

import java.util.List;

public abstract class BaseService<T> implements IBaseService<T> {
    public abstract IBaseDao<T> getDao();

    @Override
    public int deleteByPrimaryKey(Long id) {
        return getDao().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return getDao().insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return getDao().insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(Long id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return getDao().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(T record) {
        return getDao().updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return getDao().updateByPrimaryKey(record);
    }

    @Override
    public List<T> getList() {
        return getDao().getList();
    }
}
