package com.zc.Web.service;

import com.zc.Web.pojo.User;

public interface LoginService {
    User checkUser(String username, String password);
    boolean checkUid(int uid);
}
