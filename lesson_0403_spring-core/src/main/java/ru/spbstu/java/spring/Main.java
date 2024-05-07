package ru.spbstu.java.spring;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.spbstu.java.spring.components.Cat;
import ru.spbstu.java.spring.config.Configuration;
import ru.spbstu.java.spring.config.WebConfig;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        System.out.println("https://forms.gle/T5K1EYWT4yECQx456");

        // Using xml context description
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("cats.xml");
        Cat blackCat = xmlContext.getBean("blackCat", Cat.class);
        Cat greyCat = xmlContext.getBean("greyCat", Cat.class);
        Cat redCat = xmlContext.getBean("redCat", Cat.class);

        System.out.println(blackCat.getName() + "\n" + greyCat.getName() + "\n" +
                           redCat.getName());

        System.out.println(redCat.getTail().getLength());

        // Using annotations beans
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuration.class, Cat.class);
        Cat blackCatBean = ctx.getBean("blackCat", Cat.class);
        Cat greyCatBean = ctx.getBean("greyCat", Cat.class);
        Cat redCatBean = ctx.getBean("redCat", Cat.class);

        System.out.println(blackCatBean.getName() + "\n" + greyCatBean.getName() + "\n" +
                redCatBean.getName());

        System.out.println(redCatBean.getTail().getLength());

        Tomcat tomcat = new Tomcat();

        final Connector connector = new Connector();
        connector.setPort(8081);
        connector.setScheme("http");
        connector.setSecure(false);
        tomcat.setConnector(connector);

        File baseDir = null;
        try {
            baseDir = Files.createTempDirectory("embedded-tomcat").toFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Context context= tomcat.addWebapp("", baseDir.getAbsolutePath());


        // Create a Spring application context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebConfig.class);

        // Create a DispatcherServlet and register it with Tomcat
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet).setLoadOnStartup(1);
        context.addServletMappingDecoded("/*", "dispatcherServlet");


        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
        tomcat.getServer().await();

    }
}