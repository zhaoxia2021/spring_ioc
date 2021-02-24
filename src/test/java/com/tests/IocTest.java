package com.tests;

import com.beans.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IocTest {

    ApplicationContext ioc;
    @Before
    public void before(){
         ioc=new ClassPathXmlApplicationContext("spring_ioc.xml");
    }

    @Test
    public void test01(){

        //
        /*
        * ApplicationContext是spring的顶层核心接口
        * ClassPathXmlApplicationContext是根据项目路径的xml配置来实例化spring容器
        * FileSystemXmlApplicationContext是根据磁盘路径的xml配置来实例化spring容器
        * AnnotationConfigApplicationContext是根据Javaconfig（纯注解）来配置实例化spring容器
        * 在容器实例化的时候，就会加载所有的bean（容器中所有的对象或类统称为bean）
        * */
        //提到before上去，每个标记@Test方法都可用，不用每个方法都写一遍
        //ApplicationContext ioc=new ClassPathXmlApplicationContext("spring_ioc.xml");//此时已实例化bean
        /*
        * 获取bean
        * （1）通过类来获取bean---getBean（User.class）
        * (2)通过bean的名字或者id来获取bean----User bean = (User) ioc.getBean("user");
        * (3)通过名字+类型---User bean = ioc.getBean("user",User.class);
        * */
        User user = ioc.getBean(User.class);
        //User bean= (User) ioc.getBean("user");
       // User bean = ioc.getBean("user",User.class);--适用于在配置文件中配置了两个相同bean，id不同
        System.out.println(user);

    }
    /*
    * 通过别名来加载bean
    * */
    @Test
    public  void test02(){
        User u = ioc.getBean("u", User.class);
        System.out.println(u);

    }

    /*
     * 基于setter方法的依赖注入
     * */
    @Test
    public  void test03(){
        User u = ioc.getBean("user7", User.class);
        System.out.println(u);

    }

    /*
     * 基于构造函数方法的依赖注入
     * */
    @Test
    public  void test04(){
        User u = ioc.getBean("user8", User.class);
        System.out.println(u);

    }
}
