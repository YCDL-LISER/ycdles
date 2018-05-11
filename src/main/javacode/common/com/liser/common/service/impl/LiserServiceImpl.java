package com.liser.common.service.impl;

import com.liser.common.service.LiserService;

import java.io.Serializable;

public class LiserServiceImpl implements LiserService, Serializable {
    @Override
    public String sayHello(String name) {
        return "你好，这是dubbo的http协议调用！";
    }
}
