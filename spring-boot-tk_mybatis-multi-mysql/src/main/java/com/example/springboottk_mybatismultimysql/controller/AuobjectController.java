package com.example.springboottk_mybatismultimysql.controller;


import com.example.springboottk_mybatismultimysql.entity.Auobject;
import com.example.springboottk_mybatismultimysql.service.AuobjectService;
import com.example.springboottk_mybatismultimysql.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/auobject")
public class AuobjectController extends BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuobjectService auobjectService;

    public Page<Auobject> page = new Page<>(1000);

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Auobject oneInfoAuobjectTemplate(@PathVariable Long id){
        Auobject auobject = auobjectService.ListObject(id);
        return auobject;
    }

}
