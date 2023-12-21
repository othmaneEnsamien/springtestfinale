package com.example.stockspring.interceptor;

import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.util.StringUtils;

public class interceptor implements StatementInspector {

    @Override
    public String inspect(String sql) {
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            if (sql.contains("where")) {
                sql += " and identreprise = 1 ";
            } else {
                sql += " where identreprise = 1 ";
            }
        }
        return sql;
    }
}
