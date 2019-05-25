package instance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import instance.annotated.Singer;

@Configuration
public class Config {

  @Bean
  public Singer parent(){
    Singer s = new Singer();
    s.setName("John parent");
    s.setAge(30);
    return s;
  }

  @Bean
  public Singer child(){
    Singer s = new Singer();
    s.setAge(10);
    return s;
  }
  
}





