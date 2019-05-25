package sandbox;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

public class TargetDemo {

  @Configuration
  static class TargetConfig {
    @Bean
    public Foo fooImplOne(){
      return new FooImplOne();
    }

    @Bean
    public Foo fooImplTwo(){
      return new FooImplTwo();
    }

    @Bean
    public Bar bar(){
      return new Bar();
    }

    @Bean
    public Entry entry(){
      return new Entry();
    }

    @Bean
    public Guitar gogher(){
      return new Guitar();
    }
    
  }

  public static void main(String[] args) {
    GenericApplicationContext ctx = new AnnotationConfigApplicationContext(TargetConfig.class);
    Entry t = ctx.getBean(Entry.class);
    t.fooOne.sing();
    t.fooTwo.sing();

    ctx.close();
    
  }
  
}







