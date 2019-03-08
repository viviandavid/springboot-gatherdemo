package com.example.springboottk_mybatismultimysql.controller;


import com.example.springboottk_mybatismultimysql.service.AuditResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/auditResult")
public class AuditResultController extends BaseController {

    @Autowired
    private AuditResultService auditResultService;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/tableNames",method = RequestMethod.GET)
    public List<String> getTableNames(){
        List<String> list = auditResultService.getAllTableNames();
        logger.info("获取表名列表成功");
        return list;
    }

}
