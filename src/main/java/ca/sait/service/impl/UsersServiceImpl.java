package ca.sait.service.impl;

import ca.sait.dao.UsersDao;
import ca.sait.entity.UsersEntity;
import ca.sait.service.UsersService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ca.sait.common.utils.PageUtils;
import ca.sait.common.utils.Query;



@Service("usersService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsersEntity> page = this.page(
                new Query<UsersEntity>().getPage(params),
                new QueryWrapper<UsersEntity>()
        );

        return new PageUtils(page);
    }

}