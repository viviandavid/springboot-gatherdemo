package com.example.demo;

import com.example.demo.domain.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        String message = "{\"isDownload\":\"true\",\"partition\":\"59\",\"createTime\":\"2021-07-13 03:00:50\",\"fromUrl\":\"http://www.freep.com/story/news/2019/01/08/big-town-hero-closes-salem-oregon/2476472002\",\"id\":\"03f4068a642c2140\",\"source\":\"底特律自由報政治\",\"hdfsPath\":\"https://singaporespider-oss.oss-ap-southeast-1.aliyuncs.com/files/spider_news_entrepreneur/03f4068a642c2140.jpg\",\"title\":\"Big Town Hero closes last remaining location in Salem\",\"isSync\":\"true\",\"deployType\":\"1\",\"spiderId\":\"spider_news_entrepreneur\",\"url\":\" https://www.gannett-cdn.com/presto/2019/01/08/PSAL/9645ce36-5eba-4344-8381-7e5a243673a5-BigTownHero_mr01.JPG?width=660&height=441&fit=crop&format=pjpg&auto=webp\"}";
        KafkaProducer bean = applicationContext.getBean(KafkaProducer.class);
//        bean.sendMessage("files_stock_record_queue",message);

//        String faceOcr = "{\"isDownload\":\"true\",\"partition\":\"59\",\"createTime\":\"2021-07-13 03:00:50\",\"fromUrl\":\"http://www.freep.com/story/news/2019/01/08/big-town-hero-closes-salem-oregon/2476472002\",\"id\":\"03f4068a642c2140\",\"source\":\"底特律自由報政治\",\"hdfsPath\":\"https://singaporespider-oss.oss-ap-southeast-1.aliyuncs.com/files/spider_news_entrepreneur/03f4068a642c2140.jpg\",\"title\":\"Big Town Hero closes last remaining location in Salem\",\"isSync\":\"true\",\"deployType\":\"1\",\"spiderId\":\"spider_news_entrepreneur\",\"url\":\" https://www.gannett-cdn.com/presto/2019/01/08/PSAL/9645ce36-5eba-4344-8381-7e5a243673a5-BigTownHero_mr01.JPG?width=660&height=441&fit=crop&format=pjpg&auto=webp\"}";
//        bean.sendMessage("spider_file_record_queue_test",faceOcr);
    }

}
