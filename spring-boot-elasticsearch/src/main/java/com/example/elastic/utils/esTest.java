package com.example.elastic.utils;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class esTest {

    @Autowired
    private RestHighLevelClient client;
    /**
     * 单条保存
     * @param index
     * @param id
     * @param m
     */
    public void saveData(String index,String id,Map<String, Object> m){
        try {
//            RestHighLevelClient client = getClient();

            IndexRequest indexRequest = new IndexRequest(index,"test1")
                    .id(id)
                    .source(m);
            client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Date d = new Date();
        String id = d.getTime()+"";
        Map<String, Object> m = new HashMap<>();
        m.put("id", id);
        m.put("area_id", 1);
        m.put("camera_id", 1);
        m.put("log_time","2019-08-01 11:11:11");
        m.put("age", 1);
//        esTest.saveData("global_house_list",id,m);
    }
}
