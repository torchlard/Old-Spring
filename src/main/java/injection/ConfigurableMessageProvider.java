package injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider {

  private String message;

  // injected field = id name in xml
  @Autowired
  public ConfigurableMessageProvider(String message2){
    this.message = message2;
  }

  public String getMessage(){
    return this.message;
  }
  

}







