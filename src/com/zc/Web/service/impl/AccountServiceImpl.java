package com.zc.Web.service.impl;

import com.zc.Web.dao.UserDao;
import com.zc.Web.dao.impl.UserDaoImpl;
import com.zc.Web.pojo.User;
import com.zc.Web.service.AccountService;

public class AccountServiceImpl implements AccountService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean changePassword(String name, String newPassword) {
        int result=-1;
        User user = new User(name,newPassword);
        result=userDao.updateUser(name,"psw",newPassword);
        if(result==1){
            return true;
        }else return false;
    }

    @Override
    public boolean changeUserName(String oldName, String newName) {
        int result=-1;
        User user = new User(newName,null);
        result=userDao.updateUser(oldName,"uname",newName);
        if(result==1){
            return true;
        }else return false;
    }

    @Override
    public boolean layOffAccount(String name) {
        int result=-1;
        result=userDao.deleteUser(name);
        if(result==1){
            return true;
        }else return false;
    }
}
