package Simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Entry {
  static void config1(){

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
    System.out.println("=============");
    
    // MessageRenderer mr = (AnotherMessageRenderer) ctx.getBean("renderer");
    // MessageRenderer mr = (StandardOutMessageRenderer) ctx.getBean("renderer");
    MessageRenderer mr = ctx.getBean(AnotherMessageRenderer.class);
    // MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);

    // mr.setMessageProvider(new HelloWorldMessageProvider());
    mr.render();

    NumProvider num = ctx.getBean(NumProvider.class);
    int a = num.getNum();
    System.out.println("my num is " +(a+3) );
  }

  static void config2(){
    ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloConfig.class);
    MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
    mr.render();
  }
  
  public static void main(String[] args) {
    config2();
            
  }
}




