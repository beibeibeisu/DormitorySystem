package com.fjl.service;

import com.fjl.dto.ReturnMessage;
import com.fjl.pojo.loginForm;
public interface AccountService {
    /**
     * 验证登录
     * @param form
     * @return
     */
     ReturnMessage confirmLogin(loginForm form);

}
