package com.zc.Web.dao;

import com.zc.Web.annotate.UserColumns;
import com.zc.Web.annotate.UserTableInfo;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private String tableName;
    private List<String> columnsName = new ArrayList<>();

    public String getTableName() {
        return tableName;
    }

    public List<String> getColumnsName() {
        return columnsName;
    }

    public UserTable() {
        Logger logger = Logger.getLogger(UserTable.class);
        Class clazz = null;
        try {
            clazz = Class.forName("com.zc.Web.pojo.User");
            UserTableInfo userTableInfo = (UserTableInfo) clazz.getAnnotation(UserTableInfo.class);
            this.tableName = userTableInfo.tableName();

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                UserColumns userColumns = field.getAnnotation(UserColumns.class);
                columnsName.add(userColumns.columnName());
            }
        } catch (ClassNotFoundException e) {
            logger.error("未找到cLass异常" + e);
        }
    }
}
