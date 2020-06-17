package ca.sait.service;

import ca.sait.common.utils.PageUtils;
import ca.sait.entity.InventoriesEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 
 *
 * @author bin
 * @email bin.zhang@sait.ca
 * @date 2020-06-08 17:39:53
 */
public interface InventoriesService extends IService<InventoriesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

