package com.example.springbootmybatisplus.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.springbootmybatisplus.model.AuObject;
import com.example.springbootmybatisplus.dao.AuObjectMapper;
import com.example.springbootmybatisplus.service.AuObjectService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 审计对象 服务实现类
 * </p>
 *
 * @author null123
 * @since 2019-03-08
 */
@Service
public class AuObjectServiceImpl extends ServiceImpl<AuObjectMapper, AuObject> implements AuObjectService {

    @Autowired
    private AuObjectMapper auObjectMapper;

    @Override
    public Page<AuObject> selectAuObjectList(){
//        Wrapper<AuObject> wrapper = new EntityWrapper<>();
//        List<AuObject> list = auObjectMapper.selectPage(new Page<AuObject>(0,2),wrapper);
        Page<AuObject> page = new Page<>(0,2);
        Wrapper<AuObject> wrapper = new EntityWrapper<>();
        Page<AuObject> list = page.setRecords(auObjectMapper.selectPage(page,wrapper));
        return list;
    }
}
