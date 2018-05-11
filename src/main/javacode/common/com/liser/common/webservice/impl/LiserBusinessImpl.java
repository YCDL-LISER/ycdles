package com.liser.common.webservice.impl;

import com.liser.common.webservice.LiserBusiness;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.liser.common.webservice.LiserBusiness",
            serviceName = "LiserBusiness",
            targetNamespace = "http://webservice.common.liser.com/")
public class LiserBusinessImpl implements LiserBusiness {

    @Resource
    HibernateTemplate hibernateTemplate;

    public String getPersonInfo(String inputxml) {
        //String outputxml = "hello " + inputxml;
        /*Map ac01 = JSON.parseObject(inputxml, Map.class);*/
        System.out.println("输入参数：" + inputxml);
       /* Ac01 ac01 = new Ac01();
        ac01.setAac001(inputxml);
        List<Ac01> result = (List<Ac01>) hibernateTemplate.find("from Ac01 ");
        //String outputxml = JSON.
        System.out.println("输出参数：" + result);*/
        return "hello" + inputxml;
    }
}
