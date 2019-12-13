package com.zc.Web.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static Logger logger = Logger.getLogger(JDBCUtil.class);
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        Properties p = new Properties();
        InputStream is = JDBCUtil.class.getResourceAsStream("/db.properties");
        try {
            p.load(is);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            Class.forName(driver);
        } catch (IOException e) {
            logger.error("IO异常" + e);
        } catch (ClassNotFoundException e) {
            logger.error("class为找到异常" + e);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error("SQL异常" + e);
        }
        return conn;
    }

    public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
        PreparedStatement p = null;
        try {
            p = conn.prepareStatement(sql);
        } catch (SQLException e) {
            logger.error("SQL异常" + e);
        }
        return p;
    }

    public static int executeDML(String sql, Object... obj) {
        Connection conn = getConnection();
        int result = -1;
        PreparedStatement ps = getPreparedStatement(conn, sql);
        try {
            conn.setAutoCommit(false);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            result = ps.executeUpdate();
            conn.commit();
            return result;
        } catch (SQLException e) {
            logger.error("SQL异常" + e);
        }finally{
            closeAll(null,ps,conn);
        }
        return result;
    }

    public static void closeAll(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                logger.error("SQL异常" + e);
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                logger.error("SQL异常" + e);
            }
        }
        if (conn!= null) {
            try {
                conn.close();
            } catch (SQLException e) {
                logger.error("SQL异常" + e);
            }
        }
    }
}
