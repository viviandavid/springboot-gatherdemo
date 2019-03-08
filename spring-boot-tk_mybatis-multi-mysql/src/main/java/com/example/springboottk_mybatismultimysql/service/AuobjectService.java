package com.example.springboottk_mybatismultimysql.service;


import com.example.springboottk_mybatismultimysql.dao.firstdao.AuobjectMapper;
import com.example.springboottk_mybatismultimysql.entity.Auobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AuobjectService {


    @Autowired
    private AuobjectMapper auobjectMapper;

    @Autowired
    private AuditResultService auditResultService;

    public Integer checkName(String name){
        Example example = new Example(Auobject.class);
        example.createCriteria().andEqualTo("name",name);
        return auobjectMapper.selectCountByExample(example);
    }

    public Auobject ListObject(Long id){
        String name = "dde";
        Example example = new Example(Auobject.class);
        example.createCriteria().andEqualTo("name",name);
        auditResultService.getAllTableNames();
        return auobjectMapper.selectByPrimaryKey(id);
    }


    public List<Auobject> selectByGroupId(Long groupId){
        Example example = new Example(Auobject.class);
        example.createCriteria().andEqualTo("groupid",groupId);
        return auobjectMapper.selectByExample(example);
    }



}
