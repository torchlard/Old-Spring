package Simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

  @Bean
  public MessageProvider provider(){
    return new HelloWorldMessageProvider();
  }

  @Bean
  public NumProvider pro(){
    return new NumProvider();
  }


  @Bean
  public MessageRenderer renderer(){
    StandardOutMessageRenderer ren = new StandardOutMessageRenderer();
    ren.setMessageProvider(provider());
    ren.setNumProvider(pro());
    return ren;
  }

  

}











