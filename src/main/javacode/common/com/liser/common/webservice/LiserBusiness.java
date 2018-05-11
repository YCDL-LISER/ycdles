package com.liser.common.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface LiserBusiness {

    @WebMethod(operationName = "getPersonInfo")
    public String getPersonInfo(@WebParam(name = "inputxml") String inputxml);
}
