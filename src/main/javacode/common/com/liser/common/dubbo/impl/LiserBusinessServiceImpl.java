package com.liser.common.dubbo.impl;

import com.liser.common.dubbo.BusinessParam;
import com.liser.common.dubbo.BusinessResult;
import com.liser.common.dubbo.LiserBusinessService;
import org.apache.commons.lang3.StringUtils;

public class LiserBusinessServiceImpl implements LiserBusinessService {

    public BusinessResult invoke(BusinessParam param) {
        String systemKey = param.getSystemKey();
        String serviceKey = param.getServiceKey();
        Object input = param.getInput();

        if(StringUtils.isBlank(systemKey) || StringUtils.isBlank(serviceKey) || input == null){
            return new BusinessResult(BusinessResult.INVALID_PARAM_ERROR,"参数错误！");
        }


        return new BusinessResult("SUCCESS");
    }
}
