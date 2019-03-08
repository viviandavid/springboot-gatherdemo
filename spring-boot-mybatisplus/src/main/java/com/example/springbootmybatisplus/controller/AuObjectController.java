package com.example.springbootmybatisplus.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.springbootmybatisplus.model.AuObject;
import com.example.springbootmybatisplus.service.impl.AuObjectServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 审计对象 前端控制器
 * </p>
 *
 * @author null123
 * @since 2019-03-08
 */
@RestController
@RequestMapping("/test")
public class AuObjectController {

    @Autowired
    private AuObjectServiceImpl auObjectService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private Page<AuObject> selectList(){
        return auObjectService.selectAuObjectList();
    }
}

