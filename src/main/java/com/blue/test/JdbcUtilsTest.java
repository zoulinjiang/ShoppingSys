package com.blue.test;

import com.blue.utils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;


/**
 * @author shkstart
 * @create 2022-10-24 21:49
 */
public class JdbcUtilsTest {
    @Test
    public void test() {
        Connection connection=JdbcUtils.getConnection();
        System.out.println(connection);
        JdbcUtils.close(connection);
    }
}
