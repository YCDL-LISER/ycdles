package com.liser.common.service.impl;

import com.liser.common.dao.BaseDao;
import com.liser.common.service.CommonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Resource(name = "baseDao")
    BaseDao baseDao;

    public List<Object> queryAllPersonInfo() {
        List<Object> result = null;
        try {
             result = (List<Object>) baseDao.queryForAllList("Ac01.queryAllAc01");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
