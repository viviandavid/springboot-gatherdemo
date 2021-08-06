package com.example.springbootneo4j.seeder;

import com.example.springbootneo4j.dao.NeoRepository;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class runSeeder implements CommandLineRunner {

    @Resource
    private NeoRepository neoRepository;

    @Override
    public void run(String... args) throws Exception {
//        new Thread(()->{
//            neoRepository.listSyncNeoNode(25000,50000);
//        }).start();
//        new Thread(()->{
//            neoRepository.listSyncNeoNode(75001,50000);
//        }).start();
//        new Thread(()->{
//            neoRepository.listSyncNeoNode(125001,50000);
//        }).start();
//        new Thread(()->{
//            neoRepository.listSyncNeoNode(175001,50000);
//        }).start();
//        new Thread(()->{
//            neoRepository.listSyncNeoNode(225001,50000);
//        }).start();
//
        neoRepository.executeLabelAdd();
    }
}
