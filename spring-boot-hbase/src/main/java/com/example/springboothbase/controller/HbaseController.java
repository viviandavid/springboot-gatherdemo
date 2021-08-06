package com.example.springboothbase.controller;

import com.example.springboothbase.util.HBaseTemplate;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lijianlei
 * @Date 2020/5/17 15:29
 * @Version 1.0
 */
@RestController
@RequestMapping("hbase/api/")
public class HbaseController {


    @Autowired
    private HBaseTemplate hBaseTemplate;

//    @PostMapping("createTable")
//    public  Object createTable(@RequestBody String text){
//        HBaseService hBaseService = new HBaseService();
//        return   hBaseService.createTable(text);
//    }
//
    @GetMapping("test")
    public  Object createTable(){
        List<Put> puts = new ArrayList<>();
        long start = System.currentTimeMillis();
         for (int i=0;i<=1000;i++){

             System.out.println(i);
             Put  put = new Put(Bytes.toBytes("q"+i)) ;
             put.addColumn(Bytes.toBytes("question"),Bytes.toBytes("id"),Bytes.toBytes("lijianlei"));
             put.addColumn(Bytes.toBytes("question"),Bytes.toBytes("name"),Bytes.toBytes("love"));
             put.addColumn(Bytes.toBytes("question_info"),Bytes.toBytes("content"),Bytes.toBytes("ta"));
             puts.add(put);
         }
         hBaseTemplate.putRowData("question",puts);
        System.out.println("耗时："+(System.currentTimeMillis()-start)/1000 +"s");
         return  "耗时："+(System.currentTimeMillis()-start)/1000 +"s";
    }

    @GetMapping("test1")
    public  Object tst(){
        long start = System.currentTimeMillis();
        Object o = hBaseTemplate.scanStartAndStopRow("question","1","q9");
        System.out.println("耗时："+(System.currentTimeMillis()-start)/1000 +"s");
        return o  ;
    }
    @GetMapping("create")
    public  String create(){
        long start = System.currentTimeMillis();
          hBaseTemplate.createTable("question","question","question_info");
        return "----------------"  ;
    }

    @GetMapping("listTable")
    public  String listTable(){
        long start = System.currentTimeMillis();
        List<TableName> tableNames = hBaseTemplate.listTableByDefault();
        tableNames.forEach(tableName -> {
            System.out.println("---------"+Bytes.toString(tableName.getName()));
        });
        return  "biao";
    }
}