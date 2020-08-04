package ca.sait.service.impl;

import ca.sait.dao.ProductsDao;
import ca.sait.entity.ProductsEntity;
import ca.sait.service.ProductsService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ca.sait.common.utils.PageUtils;
import ca.sait.common.utils.Query;

/**
 * This class implements all the service methods to handle the products in this project.
 */

@Service("productsService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
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