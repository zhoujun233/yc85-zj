package com.zj.C85S3Springboot.bean;

import java.sql.Timestamp;
import java.util.List;

public class DmOrders {
    private Integer id;

    private Double total;

    private Timestamp createtime;

    private Integer state;

    private Integer uid;

    private Integer aid;
    
    private List<DmOrderitem> list;

    public List<DmOrderitem> getList() {
	return list;
}

public void setList(List<DmOrderitem> list) {
	this.list = list;
}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}