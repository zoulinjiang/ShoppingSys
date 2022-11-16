package com.blue.utils;

import com.blue.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-10-30 10:18
 */
public class WebUtils {

    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            System.out.println("注入之前："+bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后："+bean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     *
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
