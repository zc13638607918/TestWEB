package com.zc.Web.dao.impl;

import com.zc.Web.dao.UserDao;
import com.zc.Web.dao.UserTable;
import com.zc.Web.pojo.User;
import com.zc.Web.util.JDBCUtil;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    static private Logger logger = Logger.getLogger(UserDaoImpl.class);
    static private UserTable userTable = new UserTable();
    static private String tableName=userTable.getTableName();
    static private String id = userTable.getColumnsName().get(0);
    static private String username = userTable.getColumnsName().get(1);
    static private String psw = userTable.getColumnsName().get(2);

    @Override
    public User checkLoginDao(String name, String password) {
        String sql = "select * from " +tableName+ " where " + username + "=?";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        User user=new User();
        try {
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setUid(rs.getInt(id));
                user.setUname(rs.getString(username));
                user.setPsw(rs.getString(psw));
            }
        } catch (SQLException e) {
            logger.error("SQL异常"+e);
        } finally {
            JDBCUtil.closeAll(rs, ps, conn);
        }
        return user;
    }

    @Override
    public User checkUidDao(int uid) {
        String sql = "select * from " + userTable.getTableName() + " where " + id + "=?";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        User user=new User();
        try {
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setUid(uid);
                user.setUname(rs.getString(username));
                user.setPsw(rs.getString(psw));
            }
            return user;
        } catch (SQLException e) {
            logger.error("SQL异常"+e);
        } finally {
            JDBCUtil.closeAll(rs, ps, conn);
        }
        return user;
    }

    @Override
    public User selectUserDao(String name) {
        String sql = "select * from " + userTable.getTableName() + " where " + username + "=?";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = JDBCUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        User user=new User();
        try {
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setUid(rs.getInt(id));
                user.setUname(rs.getString(username));
                user.setPsw(rs.getString(psw));
            }
            return user;
        } catch (SQLException e) {
            logger.error("SQL异常"+e);
        } finally {
            JDBCUtil.closeAll(rs, ps, conn);
        }
        return user;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into "+tableName+" values(?,?,?)";
        return JDBCUtil.executeDML(sql,0,user.getUname(),user.getPsw());
    }

    @Override
    public int updateUser(String name,String column ,String value) {
        String sql = "update "+tableName+" set "+column+"=? where "+username+"=?";
        return JDBCUtil.executeDML(sql,value,name);
    }

    @Override
    public int deleteUser(String name) {
        String sql = "delete from "+tableName+" where "+username+"=?";
        return JDBCUtil.executeDML(sql,name);
    }
}
