package com.example.springbootmybatisplus.dao;

import com.example.springbootmybatisplus.model.AuObject;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 审计对象 Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2019-03-08
 */
@Mapper
@Repository
public interface AuObjectMapper extends BaseMapper<AuObject> {

}
