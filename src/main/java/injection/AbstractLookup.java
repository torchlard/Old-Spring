package injection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

// @Component("abstractLookup")
public abstract class AbstractLookup implements DemoBean {

  // @Lookup("singer")
  public abstract Singer getSinger();

  public void doSth(){
    getSinger().sing();
  }
  
}

