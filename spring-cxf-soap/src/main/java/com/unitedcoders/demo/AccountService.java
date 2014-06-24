package com.unitedcoders.demo;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;

@WebService
public interface AccountService {

    public String account(@WebParam(name="name", mode = Mode.IN)String name);

}
