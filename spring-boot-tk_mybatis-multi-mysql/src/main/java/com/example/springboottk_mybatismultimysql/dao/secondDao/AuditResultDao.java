package com.example.springboottk_mybatismultimysql.dao.secondDao;

import com.example.springboottk_mybatismultimysql.dao.IMapper;
import com.example.springboottk_mybatismultimysql.entity.Column;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AuditResultDao extends IMapper<Column> {

    public List<String> listAllTables();

    public List<Column> getColumns(String tableName);
}
