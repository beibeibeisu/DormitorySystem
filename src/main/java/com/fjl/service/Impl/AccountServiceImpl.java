package com.fjl.service.Impl;

import com.fjl.dto.ReturnMessage;
import com.fjl.mapper.dormitoryAdminMapper;
import com.fjl.mapper.systemAdminMapper;
import com.fjl.pojo.*;
import com.fjl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private systemAdminMapper systemAdminMapper;
    @Autowired
    public dormitoryAdminMapper dormitoryAdminMapper;
    @Override
    public ReturnMessage confirmLogin(loginForm form) {
        ReturnMessage returnMessage=new ReturnMessage<>();
        switch (form.getType()){
            case "systemAdmin": //系统管理员
                systemAdminExample systemAdminExample = new systemAdminExample();
                systemAdminExample.createCriteria().andUsernameEqualTo(form.getUsername());
                List<systemAdmin> systemAdmin;
                //判断该用户是否存在
                if ((systemAdminMapper.selectByExample(systemAdminExample)).size()==0){
                    returnMessage.setEncode(-1);
                    return returnMessage;
                }
                systemAdminExample.clear();
                //判断该账户密码是否匹配
                systemAdminExample.createCriteria().andUsernameEqualTo(form.getUsername()).andPasswordEqualTo(form.getPassword());
                if ((systemAdmin=systemAdminMapper.selectByExample(systemAdminExample)).size()==0){
                    returnMessage.setEncode(-2);
                    return returnMessage;
                }
                returnMessage.setEncode(0);
                returnMessage.setAdmin(systemAdmin.get(0));
                break;
            case "dormitoryAdmin"://宿舍管理员
                dormitoryAdminExample dormitoryAdminExample=new dormitoryAdminExample();
                dormitoryAdminExample.createCriteria().andUsernameEqualTo(form.getUsername());
                List<dormitoryAdmin> dormitoryAdmin;
                //判断用户是否存在
                if (dormitoryAdminMapper.selectByExample(dormitoryAdminExample).size()==0){
                    returnMessage.setEncode(-1);
                    return returnMessage;
                }
                dormitoryAdminExample.clear();
                dormitoryAdminExample.createCriteria().andUsernameEqualTo(form.getUsername()).andPasswordEqualTo(form.getPassword()) ;
                //判断用户密码
                if ((dormitoryAdmin=dormitoryAdminMapper.selectByExample(dormitoryAdminExample)).size()==0){
                    returnMessage.setEncode(-2);
                    return returnMessage;
                }
                returnMessage.setEncode(0);
                returnMessage.setAdmin(dormitoryAdmin.get(0));
                break;
        }
        return returnMessage;
    }
}
