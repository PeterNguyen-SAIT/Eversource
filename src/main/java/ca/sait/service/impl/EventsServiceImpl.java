package ca.sait.service.impl;

import ca.sait.dao.EventsDao;
import ca.sait.entity.EventsEntity;
import ca.sait.service.EventsService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ca.sait.common.utils.PageUtils;
import ca.sait.common.utils.Query;



@Service("eventsService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EventsServiceImpl extends ServiceImpl<EventsDao, EventsEntity> implements EventsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EventsEntity> page = this.page(
                new Query<EventsEntity>().getPage(params),
                new QueryWrapper<EventsEntity>()
        );

        return new PageUtils(page);
    }

}