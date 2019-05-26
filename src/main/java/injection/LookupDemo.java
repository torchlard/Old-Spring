package injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component("lookupDemo")
public class LookupDemo implements DemoBean {

  // @Autowired
  // @Qualifier("singer")
  private Singer singer;

  public Singer getSinger(){
    return this.singer;
  }

  public void setSinger(Singer singer){
    this.singer = singer;
  }

  public void doSth(){
    singer.sing();
  }

}










