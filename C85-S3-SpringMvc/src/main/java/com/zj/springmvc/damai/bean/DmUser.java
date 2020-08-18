package com.zj.springmvc.damai.bean;

import java.sql.Timestamp;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class DmUser {
    private Integer id;

    @NotEmpty(message = "用户名不能为空")
    @Length(min=2,max=10,message = "用户名长度必须为2到10个字符")
    private String ename;

    @NotEmpty(message = "昵称不能为空")
    @Length(min=2,max=10,message = "昵称长度必须为2到10个字符")
    private String cname;

    @NotEmpty(message = "密码不能为空")
    @Length(min=6,max=12,message = "密码长度必须为6到12个字符")
    private String password;

    @NotEmpty(message = "电子邮箱不能为空")
    @Email
    private String email;

    @NotEmpty(message = "电话号码不能为空")
    @Pattern(regexp = "\\d{11}",message =  "电话号码长度必须为11个字符")
    private String phone;

    private String sex;

    private Integer state;

    private Timestamp createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

	
    
}