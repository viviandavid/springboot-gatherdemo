package com.example.springbootmybatisplus.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.springbootmybatisplus.model.AuObject;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 审计对象 服务类
 * </p>
 *
 * @author null123
 * @since 2019-03-08
 */
public interface AuObjectService extends IService<AuObject> {

    public Page<AuObject> selectAuObjectList();
}
