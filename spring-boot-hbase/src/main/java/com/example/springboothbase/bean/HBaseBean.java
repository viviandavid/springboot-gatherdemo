package com.example.springboothbase.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HBaseBean {

    public HBaseBean( ) {
    }



    /**
     * hbase中的rowKey
     */
    private String rowKey;

    /**
     * hbase中的列族
     */
    private String columnFamily;


    /**
     * hbase 列字段名
     */
    private String columnQualifier;

    /**
     * 时间戳
     */
    private Long timeStamp;

    /**
     * 类型
     */
    private String type;


    /**
     * 值
     */
    private String value;

}