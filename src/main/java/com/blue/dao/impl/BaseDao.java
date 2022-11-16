package com.blue.dao.impl;

import com.blue.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.security.auth.login.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * @author shkstart
 * @create 2022-10-24 15:30
 */
public class BaseDao<T> {

    private QueryRunner queryRunner=new QueryRunner();

    /**
     * 进行update/insert/delete语句
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql,Object...args){
        Connection connection=JdbcUtils.getConnection();
        try {
           return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  -1;
    }
    /**
     *查询返回的javaBean对象
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T>T queryForOne(Class<T> type, String sql, Object ... args){
        Connection connection= JdbcUtils.getConnection();
        try {
            return  queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
       return null;
}


    public <T>List<T> queryForList(Class<T> type,String sql,Object...args){
        Connection connection=JdbcUtils.getConnection();
        try {
//            T t = type.newInstance();//反射创建 实体类对象，
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            while (resultSet.next()){
//                for (int i = 1; i <= metaData.getColumnCount(); i++) {
//                    Object object = resultSet.getObject(i);
//
//                }
//            }
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public <T> List<T> getForList(Class<T> clazz,String sql, Object... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<T>();
            while (rs.next()) {
                T t = clazz.newInstance();
                // 处理结果集一行数据中的每一个列:给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);
                    // 获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                list.add(t);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);

        }

        return null;
    }

    public T getForList1(Class<T> clazz,String sql, Object... args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String entity = Configuration.getProperty(MapperConstants.ENTITY_PACKAGENAME)+"."+mappedStatement.getView();
            TableInfo tableInfo = MapperInit.getConfiguration().getClassToTableInfoMap().get(Class.forName(entity));
            //表主键名
            String primaryName = tableInfo.getPrimaryKeys().get(0).getName();
            logger.debug("获取主表主键名"+primaryName);
            Map<Object,Object> map=new HashMap();
            //查询结果
            List<E> result = new ArrayList<>();
            if (null == resultSet) {
                logger.warn("查询结果为空");
                return null;
            }
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //封装数据
            while (resultSet.next()) {
                //行数据主键值
                Object primaryValue =null;
                if (sql.indexOf("count(*)") ==-1 && sql.indexOf("GROUP")==-1 && sql.indexOf("MAX")==-1 && sql.indexOf("DISTINCT")==-1){
                    primaryValue = resultSet.getObject(primaryName);
                }
                //每一行结果
                E rowObject = null;
                //返回值类型vo
                String rowObjectType = mappedStatement.getReturnType();
                if (rowObjectType.endsWith("Long") || rowObjectType.endsWith("Integer")) {
                    rowObject = (E) resultSet.getObject(1);
                    logger.debug("每一行查询结果："+rowObject);
                    result.add(rowObject);
                    return result;
                } else if (sql.indexOf("DISTINCT")!=-1){
                    //当查询select distinct语句
                    result.add((E) resultSet.getObject(1));
                    continue;
                }
                if (mappedStatement.getView().equals(mappedStatement.getReturnType()) && sql.indexOf("count(*)") ==-1&& map.containsKey(primaryValue)) {
                    rowObject = (E) map.get(primaryValue);
                } else {
                    rowObject = (E) Class.forName(Configuration.getProperty(MapperConstants.ENTITY_PACKAGENAME)+"."+rowObjectType).newInstance();
                }
                Object listEntity = null;

                Field[] fields = rowObject.getClass().getDeclaredFields();
                Map<String, Object> foreignKeyEntityMap = new HashMap<>();
                List foreignKeyEntityList = new ArrayList();

                List<Class> classList= Arrays.asList(Byte.class,Short.class,Integer.class,Long.class,Float.class,Double.class,char.class,Boolean.class,String.class,Date.class,Timestamp.class);
                //遍历返回值实体类 所有成员变量
                for (Field field : fields) {
                    //是否是外键实体类
                    boolean flag=true;
                    for (Class clazz : classList) {
                        field.setAccessible(true);
                        if (field.getType()==clazz){
                            flag=false;
                            break;
                        }
                    }
                    //不是外键实体类，跳过
                    if (flag==false){
                        continue;
                    }
                    if(field.getType()==byte[].class){
                        String fieldName = StringUtil.humpToLine(field.getName());
                        //判断查询结果集中是否存在此列
                        try{
                            if (resultSet.findColumn(fieldName) > 0){
                                //存在此列
                                byte[] bytes = resultSet.getBytes(fieldName);
                                field.setAccessible(true);
                                field.set(rowObject,bytes);
                            }
                        }catch (SQLException ignored){
                            //无事发生，忽略对实体类中的此属性赋值
                        }
                        continue;
                    }
                    if(field.getType()==Double[].class){
                        String fieldName = StringUtil.humpToLine(field.getName());
                        //判断查询结果集中是否存在此列
                        try{
                            if (resultSet.findColumn(fieldName) > 0){
                                //存在此列
                                String doublesString = resultSet.getString(fieldName);
                                field.setAccessible(true);
                                if (doublesString == null || "null".equals(doublesString)){
                                    continue;
                                }
                                field.set(rowObject, ExpData.stringToDoubleArray(doublesString));
                            }
                        }catch (SQLException ignored){
                            //无事发生，忽略对实体类中的此属性赋值
                        }
                        continue;
                    }
                    if (field.getType()==List.class || field.getType()==ArrayList.class) {
                        if (field.get(rowObject) == null) {
                            String fieldName = field.getName();
                            List foreignKeyList=new ArrayList();
                            ReflectUtil.invokeSetAttribute(rowObject,fieldName,foreignKeyList);
                        }
                        Type genericType = field.getGenericType();
                        if (genericType instanceof ParameterizedType) {
                            ParameterizedType pt = (ParameterizedType) genericType;
                            // 得到泛型里的class类型对象
                            Class<?> actualTypeArgument = (Class<?>) pt.getActualTypeArguments()[0];
                            listEntity = actualTypeArgument.newInstance();
                        }
                        List foreignKeyList = (List) field.get(rowObject);
                        foreignKeyList.add(listEntity);

                        foreignKeyEntityList.add(listEntity);
                    }
                    else {
                        String name = field.getName();
                        if(field.get(rowObject)==null){
                            Object foreignKeyEntity = field.getType().newInstance();
                            ReflectUtil.invokeSet(rowObject, name, foreignKeyEntity);
                            foreignKeyEntityMap.put(name, foreignKeyEntity);
                        }else {
                            foreignKeyEntityMap.put(name,field.get(rowObject));
                        }
                    }
                }
                //封装数据
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {

                    String columnName = resultSetMetaData.getColumnLabel(i + 1);
                    Object columnValue = resultSet.getObject(i + 1);

                    String columnClassName = StringUtil.lineToHump(columnName);
                    //基本类型封装
                    Field[] declaredFields = rowObject.getClass().getDeclaredFields();
                    for (Field declaredField : declaredFields) {
                        if (declaredField.getName().equals(columnClassName)&& columnValue != null){
                            ReflectUtil.invokeSet(rowObject, columnClassName, columnValue);
                        }
                    }

                    for (Object o : foreignKeyEntityList) {
                        Field[] declaredFields1 = o.getClass().getDeclaredFields();
                        for (Field declaredField1 : declaredFields1) {
                            if (declaredField1.getName().equals(columnClassName)&& columnValue != null){
                                ReflectUtil.invokeSet(o, columnClassName, columnValue);
                            }
                        }
                    }
                    for (Object value : foreignKeyEntityMap.values()) {
                        Field[] declaredFields1 = value.getClass().getDeclaredFields();
                        for (Field field : declaredFields1) {
                            if (field.getName().equals(columnClassName)&& columnValue != null){
                                ReflectUtil.invokeSet(value, columnClassName, columnValue);
                            }
                        }
                    }
                }

                if (sql.indexOf("count(*)") ==-1&&mappedStatement.getView().equals(mappedStatement.getReturnType()) && !map.containsKey(primaryValue)) {
                    map.put(primaryValue, rowObject);
                }
                if (!result.contains(rowObject)) {
                    result.add(rowObject);
                }

            }
            logger.debug("查询结果:"+result.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);

        }

        return null;
    }

    /*public <T> T getInstance(Class<T> clazz,String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);

                    // 获取每个列的列名
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);

        }

        return null;
    }
*/
}
