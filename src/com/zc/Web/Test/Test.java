package com.zc.Web.Test;

import com.zc.Web.dao.UserDao;
import com.zc.Web.dao.impl.UserDaoImpl;
import com.zc.Web.pojo.User;
import com.zc.Web.service.AccountService;
import com.zc.Web.service.LoginService;
import com.zc.Web.service.impl.AccountServiceImpl;
import com.zc.Web.service.impl.LoginServiceImpl;
import org.apache.log4j.Logger;

public class Test {
    private static Logger logger =Logger.getLogger(Test.class);
    public static void main(String[] args){
        AccountService as = new AccountServiceImpl();
        as.changePassword("蔡天慧","123");
        as.changeUserName("周超","周小超");
        as.changePassword("周小超","456");
    }
}
