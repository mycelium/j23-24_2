package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("https://forms.gle/T5K1EYWT4yECQx456");

        // Using xml context description
        ApplicationContext context = new ClassPathXmlApplicationContext("cats.xml");
        Cat blackCat = context.getBean("blackCat", Cat.class);
        Cat greyCat = context.getBean("greyCat", Cat.class);
        Cat redCat = context.getBean("redCat", Cat.class);

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
    }
}