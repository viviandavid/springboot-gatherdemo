package com.example.springboothbase.config;

import com.example.springboothbase.util.HBaseTemplate;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


/**
 * hbase  onfig
 *
 * @Author lijianlei
 * @Date 2020/5/16 16:10
 * @Version 1.0
 */
@Configuration
public class HBaseConfig {

    @Bean
    public HBaseTemplate hBaseTemplate() {
        Connection connection = null;
        try {
            Map<String, String> hBasePropertiesConf = loadHBaseProperties();
            if (hBasePropertiesConf.size()<0) {
                throw new NullPointerException();
            }
            Set<Map.Entry<String, String>> entries = hBasePropertiesConf.entrySet();
            org.apache.hadoop.conf.Configuration hbaseConf = HBaseConfiguration.create();
            entries.forEach(object -> {
                hbaseConf.set(object.getKey(), object.getValue());
            });
            connection = ConnectionFactory.createConnection(hbaseConf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HBaseTemplate(connection);
    }



    /**
     * 加载hbase配置文件
     *
     * @return
     */
    private Map<String, String> loadHBaseProperties() {
        Map<String, String> propertiesMap = new HashMap<>();
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties("hbase.properties");
            for (Object key : properties.keySet()) {
                String keyStr = key.toString();
                // PropertiesLoaderUtils的默认编码是ISO-8859-1,在这里转码一下
                propertiesMap.put(keyStr, new String(properties.getProperty(keyStr).getBytes("ISO-8859-1"), "utf-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertiesMap;
    }

}