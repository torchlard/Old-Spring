package injection;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service("entry")
public class Entry {

  private String someValue;

  public Entry(String some){
    this.someValue = some;
  }

  @Autowired
  public Entry(@Value("90") int someVal){
    this.someValue = "Number: " + someVal;
  }

  public String toString(){
    return someValue;
  }

  public static <T> void count(String name, Supplier<T> supp){
    StopWatch watch = new StopWatch();
    watch.start();
    for(int i=0; i<100_000; i++){
      T out = supp.get();
    }
    watch.stop();
    System.out.println(name + "-time: " + watch.getTotalTimeMillis() );
  }

  public static void main(String[] args) {

    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("spring/app-injection.xml");
    ctx.refresh();

    Entry cc = (Entry) ctx.getBean("entry");
    System.out.println(cc);

    ConfigurableMessageProvider cf = (ConfigurableMessageProvider) ctx.getBean("provider");
    System.out.println(cf.getMessage());

    DemoBean bean1 = ctx.getBean("lookupDemo", DemoBean.class);
    DemoBean bean2 = ctx.getBean("abstractLookup", DemoBean.class);

    Singer singer1 = bean1.getSinger();    
    Singer singer2 = bean2.getSinger();


    ReplacementTarget target = (ReplacementTarget) ctx.getBean("replacementTarget");
    ReplacementTarget t2 = (ReplacementTarget) ctx.getBean("standardTarget");
    
    Supplier<String> supp = () -> target.formatMessage("thanks for playing, try again");
    count("rep", supp);

    Supplier<String> s2 = () -> t2.formatMessage("thx for playing");
    count("standard", s2);




    // watch.start();
    // for(int x=0; x<100_000; x++){
    //   Singer singer = bean1.getSinger();
    //   singer.sing();
    // }
    // watch.stop();
    // System.out.println("lookup bean: " + watch.getTotalTimeMillis());

    
    // watch.start();
    // for(int x=0; x<100_000; x++){
    //   Singer singer = bean2.getSinger();
    //   singer.sing();
    // }
    // watch.stop();
    // System.out.println("abstract bean: " + watch.getTotalTimeMillis());


    ctx.close();
  }

  
}








