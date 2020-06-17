package ca.sait.service.impl;

import ca.sait.common.utils.PageUtils;
import ca.sait.common.utils.Query;
import ca.sait.dao.DiscountsDao;
import ca.sait.entity.DiscountsEntity;
import ca.sait.service.DiscountsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("discountsService")
public class DiscountsServiceImpl extends ServiceImpl<DiscountsDao, DiscountsEntity> implements DiscountsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DiscountsEntity> page = this.page(
                new Query<DiscountsEntity>().getPage(params),
                new QueryWrapper<DiscountsEntity>()
        );

        return new PageUtils(page);
    }

}