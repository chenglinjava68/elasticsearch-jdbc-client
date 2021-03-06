package com.alibaba.druid.pool;

import com.alibaba.druid.util.jdbc.ResultSetMetaDataBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoqijun on 2016/11/10.
 */
public class ElasticSearchResultSetMetaDataBase extends ResultSetMetaDataBase{

    public ElasticSearchResultSetMetaDataBase(List<String> headers) {
        for(String column:headers){
            ColumnMetaData columnMetaData = new ColumnMetaData();
            columnMetaData.setColumnLabel(column);
            columnMetaData.setColumnName(column);
            getColumns().add(columnMetaData);
        }
    }
}
