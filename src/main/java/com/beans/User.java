package com.beans;

public class User {
    private  Integer id;
    private String username;
    private  String realname;

    public Integer getId() {
        return id;
    }

    //无参构造函数
    public User() {
        System.out.println("User已加载");
    }
    //有参构造函数
    public User(Integer id, String username, String realname) {
        this.id = id;
        this.username = username;
        this.realname = realname;
    }

    //基于setter方法的依赖注入 对应的set方法的名字 如setId则对应的配置文件中name=“id” ；setXxx对应name=“xxx”
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
