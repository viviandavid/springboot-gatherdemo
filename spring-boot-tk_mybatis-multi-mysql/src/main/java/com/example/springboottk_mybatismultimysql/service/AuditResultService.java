package com.example.springboottk_mybatismultimysql.service;

import com.example.springboottk_mybatismultimysql.dao.secondDao.AuditResultDao;
import com.example.springboottk_mybatismultimysql.entity.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuditResultService {

    private static Logger logger = LoggerFactory.getLogger(AuditResultService.class);
    @Autowired
    private AuditResultDao auditResultDao;

    //不展示的列
    private String[] filterColumns = {"id"};
    //默认的列名对应
    private Map<String, String> defaultColumnNameMap = new HashMap<>();

    {
        defaultColumnNameMap.put("inserttime", "采集时间");
    }

    public List<String> getAllTableNames() {
//        auditResultDao.selectAll();
        return auditResultDao.listAllTables();
    }

    public List<Column> getColumns(String tableName) {
        return auditResultDao.getColumns(tableName);
    }

}
