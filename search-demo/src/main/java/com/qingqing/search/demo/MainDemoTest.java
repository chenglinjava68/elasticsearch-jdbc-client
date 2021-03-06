package com.qingqing.search.demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.ElasticSearchDruidDataSourceFactory;
import org.elasticsearch.common.collect.Lists;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

/**
 * Created by yaoqijun on 2016/11/10.
 */
public class MainDemoTest {
    public static void main(String[] args) throws Exception {
        System.out.println("main result");
        Properties properties = new Properties();
        properties.put("url", "result:elasticsearch://localhost:9300/teacher");
        DruidDataSource dds = (DruidDataSource) ElasticSearchDruidDataSourceFactory.createDataSource(properties);
        dds.setInitialSize(1);
        Connection connection = dds.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from teacher");
        List<String> columns = Lists.newArrayList("id", "name", "age", "salary");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println("-------------------------------");
            for (String column : columns) {
                System.out.print("  " + column + " is : " + resultSet.getObject(column).toString());
            }
            System.out.println("");
            System.out.println("-------------------------------");
        }

        ps.close();
        connection.close();
        dds.close();
    }
}
