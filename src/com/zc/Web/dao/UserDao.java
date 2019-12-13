package com.zc.Web.dao;

import com.zc.Web.pojo.User;

public interface UserDao {
    User checkLoginDao(String name,String password);
    User checkUidDao(int uid);
    User selectUserDao(String name);
    int insertUser(User user);
    int updateUser(String name,String column ,String value);
    int deleteUser(String name);
}
