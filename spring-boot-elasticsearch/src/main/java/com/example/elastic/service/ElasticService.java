package com.example.elastic.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.RewriteException;
import lombok.extern.java.Log;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
@Log
public class ElasticService implements Runnable{

    private static BlockingQueue<JSONObject> docs = new LinkedBlockingQueue<>(1000);

    @Autowired
    private RestHighLevelClient client;



    public boolean IndexExists() throws IOException {

//        QueryBuilder queryBuilder = QueryBuilders.matchQuery("age",1);
//        SearchTemplateRequest templateRequest = new SearchTemplateRequest();
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(queryBuilder);
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.source(searchSourceBuilder);
//        client.search(searchRequest,RequestOptions.DEFAULT)
        GetRequest getRequest = new GetRequest();
        getRequest.index("global_house_list").id("1572502958266");
        return client.exists(getRequest,RequestOptions.DEFAULT);
    }


    public void dealSeclog(){
        long start = System.currentTimeMillis();
        try {
            /**
             * 随机数
             */
            String sid = UUID.randomUUID().toString();
            Integer cusid = 862;
            String isanalyzerevent ="1";

            String detail = "6a653469-d9f2-49cd-ac90-6aaf57f73952\t862\tcollector\t1\t0\t1\t\t完成定时任务\tfinished 0anacron\t1\tmedium\tunknown\t<77>Oct 29 19:01:01 kh167 run-parts(/etc/cron.hourly)[2180 finished 0anacron\t\t202\ttrue\tSystem\tOthers\tNotification\t010202\tfalse\t0\tOthers\t0\t0\t2020-10-29 19:01:01\t2020-10-29 19:01:01\t2020-10-29 19:01:01\t20201029190101\t20201029190101\t10.20.4.167\t7\t\t\t\t\t\t\t\tfalse\t\t\t0\t\t0\t\t\t\t\t\t\t\t\t\t\t\t\t\tfalse\t\t\t0\t\t0\t\t\t\t\t\t\t\t\t2020-10-29 19:01:01\t2020-10-29 19:01:01\t2020-10-29 19:01:01\t0.0\t0.0\t\t\t\t\t\t\t\t2020-10-29 19:01:01\t2020-10-29 19:01:01\t2020-10-29 19:01:01\t0.0\t0.0\t\t2\t\t\t\t10.20.4.167\t\t1,2,4,5,6,7,8,9,10,31,40,46,74,75\t1\t7\t167资产\t\t\t\t\t\t\tssh\t\t168\t496\t\t\t\t\t\t\t\t\t\t\t\t\t\t1\t\t1\t未分配或者内网IP|0|0|0|0\t未分配或者内网IP|0|0|0|0\t未分配或者内网IP|0|0|0|0";

            String eventname = "完成定时任务";
            String eventlevel = "medium";
            String eventcategory = "System";
            String eventcategorytechnique = "Notification";
            String categorydevice = "010202";
            Long devicereceipttime = System.currentTimeMillis();

            Long collectreceipttime = System.currentTimeMillis();

            String srcaddress ="10.20.4.167";
            String taraddress = "";
            String deviceaddress = "10.20.4.167";
            Long entid = 1L;
            String analyzereventidlist = "";
            String deviceproduct = "ssh";
            String tarzone = "";
            JSONObject object = new JSONObject();
            object.put("sid", sid);
            object.put("cusid", cusid.toString());
            object.put("isanalyzerevent", isanalyzerevent);
            object.put("eventname", eventname);
            object.put("eventlevel", eventlevel);
            object.put("eventcategory", eventcategory);
            object.put("eventcategorytechnique", eventcategorytechnique);
            object.put("categorydevice", categorydevice);
            object.put("devicereceipttime", devicereceipttime);
            object.put("collectreceipttime", collectreceipttime);
            object.put("srcaddress", srcaddress);
            object.put("taraddress", taraddress);
            object.put("deviceaddress", deviceaddress);
            object.put("entid", entid.toString());
            object.put("analyzereventidlist", analyzereventidlist);
            object.put("detail", detail);
            object.put("deviceproduct", deviceproduct);
            object.put("tarzone", tarzone);
            docs.put(object);
            if(docs.size()>=1000){
                List<JSONObject> list = new ArrayList<>();
                docs.drainTo(list);
                if (list!=null&&!list.isEmpty()){
                    addLog(list);
                }
                docs.clear();
            }

        } catch (Exception e) {
            log.info(e.getMessage()+"详细信息"+e);
        }
        long end = System.currentTimeMillis();
        log.info((end - start) + "ms");
    }


    public void addLog(List<JSONObject> list){
        try {
            log.info("有"+list.size()+"条数据,发送数据到elasticsearch,时间："+ LocalDateTime.now());
            BulkRequest bulkRequest = new BulkRequest();
            list.stream().forEach(x->
                    bulkRequest.add(new IndexRequest().index("eventlog").type("_doc").id(x.getString("sid"))
                            .source(JSON.toJSONString(x), XContentType.JSON))
            );
            client.bulk(bulkRequest,RequestOptions.DEFAULT);
            log.info("有"+list.size()+"条数据,发送成功，时间："+LocalDateTime.now());
        }catch (Exception e){
            e.printStackTrace();
            log.info("保存失败！");
        }
    }

    public void test() throws IOException {
        SearchTemplateRequest request = new SearchTemplateRequest();
        request.setRequest(new SearchRequest("mytest"));
        request.setScriptType(ScriptType.INLINE);
        String sql = null;
        request.setScript(sql);
        Map<String,Object> stringObjectMap = new HashMap<>();
        request.setScriptParams(stringObjectMap);

        SearchTemplateResponse response = client.searchTemplate(request, RequestOptions.DEFAULT);
        response.getResponse();
    }


    @Override
    public void run() {
        while (true){
            dealSeclog();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
