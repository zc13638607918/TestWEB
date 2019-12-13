package com.zc.Web.pojo;

import com.zc.Web.annotate.UserColumns;
import com.zc.Web.annotate.UserTableInfo;

@UserTableInfo(tableName = "user")
public class User {
    @UserColumns(columnName = "uid")
    int uid;
    @UserColumns(columnName = "uname")
    String uname;
    @UserColumns(columnName = "psw")
    String psw;

    public User(String uname, String psw) {
        this.uname = uname;
        this.psw = psw;
    }
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
