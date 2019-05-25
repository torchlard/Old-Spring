package sandbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("gogher")
public class FooImplTwo implements Foo, ApplicationContextAware{

  ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext ctx){
    this.applicationContext = ctx;
  }
  
  private Guitar guitar;
  public FooImplTwo(){}
  
  public void sing(){
    System.out.println("I am foo two");
    guitar = applicationContext.getBean("gogher", Guitar.class);
    guitar.sing();

  }
}

