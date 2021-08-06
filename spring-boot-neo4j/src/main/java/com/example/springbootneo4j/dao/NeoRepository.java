package com.example.springbootneo4j.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;
import org.apache.commons.lang3.StringUtils;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class NeoRepository {

    @Resource
    private Session neoSession;

    /**
     * 获取指定数量的节点id、名称和标签
     */
    public Set<Object> listSyncNeoNode(int skipNumber, int perNumber) {
        String query = String.format("match (n) return labels(n) as labels,id(n) as id,properties(n) as pro order by id(n) skip %d limit %d ", skipNumber, perNumber);
        StatementResult result = neoSession.run(query);
        while (result.hasNext()) {
            Record record = result.next();
            Integer id = record.get("id").asInt();
            Map<String, Object> map = record.get("pro").asMap();
            Object name = map.get("name");
//            System.out.println(name);
//            StringBuilder sb = new StringBuilder();
//            sb.append("{");
//            map.forEach((k, v) -> {
//                if ("别名".equals(k)) {
//                    JSONArray objects = JSONObject.parseArray(JSON.toJSONString(v));
//                    StringBuilder sb1 = new StringBuilder();
//                    for (int i = 0; i < objects.size(); i++) {
//                        sb1.append("'").append(objects.get(i)).append("'").append(",");
//                    }
//                    sb.append(k).append(":").append("[").append(sb1.toString(), 0, sb1.toString().length() - 1)
//                            .append("]").append(",");
//                } else {
//                    sb.append(k).append(":").append("'").append(v).append("'").append(",");
//                }
//            });
//            String substring = sb.toString().substring(0, sb.toString().length() - 1);
//            substring += "}";
//            List<String> labels = record.get("labels").asList()
//                    .stream().map(x -> String.valueOf(x)).collect(Collectors.toList());
//            if (labels.contains("60c867d25ca58f70989d59a9")) {
//                System.out.println("包含这个标签！！！");
//            } else {
//                labels.add("60c867d25ca58f70989d59a9");
//            }
//            String format = String.format("merge(n%s %s) return n", labelsTranslator(labels), substring);
//            System.out.println(format);
//            neoSession.run(format);
            // 写入到neo4j
            if (!name.toString().contains("'")) {
                String format = String.format("match (n{name:'%s'}) set n:c867d25ca58f70989d59a960", name);
                System.out.println(format);
                neoSession.run(format);
            }
        }
        return new HashSet<>();
    }

    public static String labelsTranslator(List<String> labels) {
        StringBuilder builder = new StringBuilder();
        labels.forEach(label -> builder.append(":`").append(label).append("`"));
        return builder.toString();
    }

    public void executeLabelAdd(){
        Set<String> stringSet = labelSet();
        stringSet.stream().forEach(x->{
            String format = String.format("match (n:`%s`) set n:c867d25ca58f70989d59a960", x);
            System.out.println(format);
            neoSession.run(format);
        });
    }

    public Set<String> labelSet() {
        // 6.12  知识图谱添加标签
        String label = "c867d25ca58f70989d59a960";
        String query = null;
        Set<String> labels = new HashSet<>();
        query = "MATCH (n:" + "`" + label + "`" + ") with labels(n) as kk unwind kk as k  return collect(distinct k)";
        List<Record> resultColumn = executeSql(neoSession, query);
        resultColumn.stream().map(record -> record.values())
                .collect(Collectors.toList()).stream()
                .forEach(x -> x.stream().forEach(y -> y.asList().stream()
                        .forEach(z -> labels.add(z.toString()))));
        if (labels.contains(label)) {
            labels.remove(label);
        }
        return labels;
    }

    public static List<Record> executeSql(Session session, String sql) {
        StatementResult result = session.run(sql);
        List<Record> list = new ArrayList<>();
        if (result.hasNext()) {
            list = result.list();
//            list = result.single().values().get(0).asList();
        }
        return list;
    }
}
