package com.liser.common.dubbo;

public interface LiserBusinessService {

    /**
     * 通用的调用服务方法
     * @param param
     * @return
     */
    BusinessResult invoke(BusinessParam param);
}
