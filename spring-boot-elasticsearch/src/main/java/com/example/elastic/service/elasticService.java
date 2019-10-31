package com.example.elastic.service;

import org.apache.tomcat.util.buf.Utf8Encoder;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateRequestBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class elasticService {

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


}
