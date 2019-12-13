package com.zc.Web.service.impl;

import com.zc.Web.dao.UserDao;
import com.zc.Web.dao.impl.UserDaoImpl;
import com.zc.Web.pojo.User;
import com.zc.Web.service.LoginService;

public class LoginServiceImpl implements LoginService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User checkUser(String username, String password) {
        return userDao.checkLoginDao(username, password);
    }

    @Override
    public boolean checkUid(int uid) {
        User user = userDao.checkUidDao(uid);
        if (user != null) {
            return true;
        }
        return false;
    }
}
