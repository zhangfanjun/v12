package com.qf.v12_service.product;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.entity.TProduct;
import com.qf.entity.TProductDesc;
import com.qf.mapper.TProductDescMapper;
import com.qf.mapper.TProductMapper;
import com.qf.v12.api.IProductService;
import com.qf.v12.base.IBaseDao;
import com.qf.v12.base.impl.BaseService;
import com.qf.v12.entity.TProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService extends BaseService<TProduct> implements IProductService {
    @Autowired
    private TProductMapper productMapper;
    @Autowired
    private TProductDescMapper descMapper;
    @Override
    public IBaseDao<TProduct> getDao() {
        return productMapper;
    }

    @Override
    public PageInfo<TProduct> getPage(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<TProduct> list = getList();
        PageInfo<TProduct> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    @Transactional
    public Long addProductVO(TProductVO tProductVO) {
        TProduct product = tProductVO.getProduct();
        int insert = productMapper.insert(product);
        TProductDesc tProductDesc = new TProductDesc();
        tProductDesc.setProductDesc(tProductVO.getDesc());
        //必须做主键回填才有id
        tProductDesc.setProductId(product.getId());
        descMapper.insert(tProductDesc);
        return product.getId();
    }

    @Override
    public int bathDel(List<Long> list) {
        return productMapper.bathDel(list);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        TProduct t = new TProduct();
        t.setId(id);
        t.setFlag(false);
        return super.updateByPrimaryKeySelective(t);
    }
}
