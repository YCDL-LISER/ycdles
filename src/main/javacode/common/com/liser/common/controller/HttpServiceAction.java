package com.liser.common.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/httpService")
public class HttpServiceAction {

    @Autowired
    HibernateTemplate hibernateTemplate;

    @ResponseBody
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public Map<String, Object> userLogin(String uname, String pwd) throws Exception{
        String a = uname;
        String b = pwd;
        Map<String, Object> data = new HashMap<String, Object>();
        if(a == null || a == "" || b == null || b == ""){
            data.put("userstatus","error");
        }else {
            data.put("userstatus","success");
            data.put("username","你好："+a);
            data.put("password","密码是："+b);
        }
        return data;
    }
}
