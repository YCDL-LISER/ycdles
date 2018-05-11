package com.liser.common.controller;

import com.liser.common.service.CommonService;
import org.apache.log4j.net.SocketServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexAction {

    @Resource(name = "commonService")
    CommonService commonService;

    @Resource
    HibernateTemplate hibernateTemplate;

    @RequestMapping("indexAction")
    public String index() throws Exception {

        ApplicationContext app = new ClassPathXmlApplicationContext("app-context.xml");
        //SocketServer socketServer = (SocketServer) app.getBean("nettyService");
       // socketServer.start();

       /* List<Ac01> result = (List<Ac01>) commonService.queryAllPersonInfo();
        System.out.println(result.get(0).toString());

        List<Ac02> result2 = (List<Ac02>) hibernateTemplate.find("from Ac02 ");
        System.out.println(result2.get(0).getAac001() + result2.get(0).getAae140());*/

        return null;
    }

}
