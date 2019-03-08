package com.example.springbootmybatisplus.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 审计对象
 * </p>
 *
 * @author null123
 * @since 2019-03-08
 */
@TableName("au_object")
public class AuObject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    private String updatetime;
    private String createuserid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getLogtime() {
        return logtime;
    }

    public void setLogtime(Integer logtime) {
        this.logtime = logtime;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getCreatetime() {
        return createtime;
    }

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

    @Override
    public String toString() {
        return "AuObject{" +
        ", id=" + id +
        ", name=" + name +
        ", remark=" + remark +
        ", schedule=" + schedule +
        ", enable=" + enable +
        ", logtime=" + logtime +
        ", groupid=" + groupid +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", createuserid=" + createuserid +
        "}";
    }
}
