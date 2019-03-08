package com.example.springboottk_mybatismultimysql.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "au_object")
public class Auobject implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * remark
     */
    private String remark;

    /**
     * schedule
     */
    private Integer schedule;

    /**
     * enable
     */
    private Integer enable;

    /**
     * logtime
     */
    private Integer logtime;

    private Long groupid;

    /**
     * createtime
     */
    private String createtime;

    /**
     * updatetime
     */
    private String updatetime;

    /**
     * createuserid
     */
    private String createuserid;

    /**
     * 模板ID
     */
    @Transient
    private String templateIds;


    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取name
     *
     * @return name - name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取remark
     *
     * @return remark - remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置remark
     *
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取schedule
     *
     * @return schedule - schedule
     */
    public Integer getSchedule() {
        return schedule;
    }

    /**
     * 设置schedule
     *
     * @param schedule schedule
     */
    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    /**
     * 获取enable
     *
     * @return enable - enable
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * 设置enable
     *
     * @param enable enable
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    /**
     * 获取logtime
     *
     * @return logtime - logtime
     */
    public Integer getLogtime() {
        return logtime;
    }

    /**
     * 设置logtime
     *
     * @param logtime logtime
     */
    public void setLogtime(Integer logtime) {
        this.logtime = logtime;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    /**
     * 获取createtime
     *
     * @return createtime - createtime
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置createtime
     *
     * @param createtime createtime
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    public String getTemplateIds() {
        return templateIds;
    }

    public void setTemplateIds(String templateIds) {
        this.templateIds = templateIds;
    }

}