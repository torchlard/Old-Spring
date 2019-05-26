package autowire;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectCollection")
public class Entry {

  private Foo foo1;
  private Foo foo2;
  private Bar bar;

  @Autowired
  @Qualifier("map")
  private Map<String,Object> map;

  // @Resource(name="set")
  @Autowired
  @Qualifier("set")
  private Set set;

  @Resource(name="list")
  private List list;
  

  public Entry(){}
  public Entry(Foo foo){
    System.out.println("foo");
  }
  public Entry(Foo foo, Bar bar){
    System.out.println("foo bar");
  }
  public void setFoo1(Foo foo1){
    this.foo1 = foo1;
    System.out.println("foo1");
  }
  public void setFoo2(Foo foo2){
    this.foo2 = foo2;
    System.out.println("foo2");
  }

  public void setBar(Bar bar){
    this.bar = bar;
    System.out.println("bar");
  }

  public void displayInfo(){
    System.out.println("map contents:");
    map.entrySet().stream().forEach(i -> System.out.println(
      "Key: "+i.getKey() +", value: " + i.getValue() ));

    System.out.println("set content: ");
    set.forEach(i -> System.out.println("value: " + i));
    
  }


  public static void main(String[] args) {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:spring/app-autowire.xml");
    ctx.refresh();

    Entry t = null;
    System.out.println("using byname");
    t = (Entry) ctx.getBean("targetByName");

    System.out.println("using bytype");
    t = ctx.getBean("targetByType", Entry.class);

    System.out.println("using constructor");
    t = ctx.getBean("targetConstructor", Entry.class);

    Map<String,Foo> beans = ctx.getBeansOfType(Foo.class);
    beans.entrySet().stream().forEach(i -> 
      System.out.println("id: "+i.getKey() +", alias"+ Arrays.toString(ctx.getAliases(i.getKey())) ));

    Entry entry = (Entry) ctx.getBean("injectCollection");
    entry.displayInfo();

  }

  
}












