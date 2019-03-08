package com.example.springboottk_mybatismultimysql.dao.firstdao;

import com.example.springboottk_mybatismultimysql.dao.IMapper;
import com.example.springboottk_mybatismultimysql.entity.Auobject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuobjectMapper extends IMapper<Auobject> {

//    public Auobject auobjectInfo(Auobject auobject);

}