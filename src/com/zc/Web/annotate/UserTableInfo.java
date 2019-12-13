package com.zc.Web.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(value = RUNTIME)
@Target(ElementType.TYPE)
public @interface UserTableInfo {
    String tableName();
}

