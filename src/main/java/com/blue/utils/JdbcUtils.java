package com.blue.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2022-10-24 21:27
 */
public class JdbcUtils {
    private static DruidDataSource druidDataSource;

    static {
        try {
            Properties properties = new Properties();
            //读取properties配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //建立数据库连接池
            druidDataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池里面的连接
     * @return 为null则是连接失败
     */
    public static Connection getConnection() {
        Connection connection=null;
        try {
            connection=druidDataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     * 断开连接
     * @param con
     */
    public static void close(Connection con) {
        if(con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
