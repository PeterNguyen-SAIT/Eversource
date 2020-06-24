package ca.sait.service.impl;


import ca.sait.common.utils.PageUtils;
import ca.sait.common.utils.Query;
import ca.sait.dao.UsersDao;
import ca.sait.entity.UsersEntity;
import ca.sait.service.UsersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("usersService")
public class UsersServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UsersService {
//    @Autowired
//    UsersDao usersDao;
//
//    public UsersEntity findByUname(String uname) {
//        QueryWrapper queryWrapper = new QueryWrapper("UsersEntity",uname);
//        List list = usersDao.selectList(queryWrapper);
//
//        return null;
//    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsersEntity> page = this.page(
                new Query<UsersEntity>().getPage(params),
                new QueryWrapper<UsersEntity>()
        );

        return new PageUtils(page);
    }

}