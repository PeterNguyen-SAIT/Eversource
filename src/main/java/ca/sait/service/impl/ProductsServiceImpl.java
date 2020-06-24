package ca.sait.service.impl;


import ca.sait.common.utils.PageUtils;
import ca.sait.common.utils.Query;
import ca.sait.dao.ProductsDao;
import ca.sait.entity.ProductsEntity;
import ca.sait.service.ProductsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("productsService")
public class ProductsServiceImpl extends ServiceImpl<ProductsDao, ProductsEntity> implements ProductsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductsEntity> page = this.page(
                new Query<ProductsEntity>().getPage(params),
                new QueryWrapper<ProductsEntity>()
        );

        return new PageUtils(page);
    }

}