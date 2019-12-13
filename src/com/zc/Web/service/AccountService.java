package com.zc.Web.service;

public interface AccountService {
    boolean changePassword(String name,String newPassword);
    boolean changeUserName(String oldName,String newName);
    boolean layOffAccount(String name);
}
