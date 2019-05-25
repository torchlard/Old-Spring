package instance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import instance.annotated.Singer;

public class Entry {
  public static void main(String[] args) {

    // GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    // ctx.load("classpath:spring/app-context-annotated.xml");
    // ctx.refresh();

    ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

    // Singer singer1 = ctx.getBean("nonSingleton", Singer.class);
    // Singer singer2 = ctx.getBean("nonSingleton", Singer.class);

    Singer parent = ctx.getBean("parent", Singer.class);
    Singer child = ctx.getBean("child", Singer.class);

    // System.out.println("identity equal? " + (singer1 == singer2) );
    // System.out.println("value equal? " + (singer1.equals(singer2)) );
    System.out.println("parent: " + parent);
    System.out.println("child: " + child);

    // ctx.close();
    
  }
}






