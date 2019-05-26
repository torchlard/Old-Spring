package sandbox;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("gigi")
// @Lazy
public class Entry {

  Foo fooOne;
  Foo fooTwo;
  Bar bar;

  public Entry(){
    System.out.println("Entry()");
  }
  public Entry(Foo fooOne){
    System.out.println("Entry(fooOne)");
  }
  public Entry(Foo fooOne, Bar bar){
    System.out.println("Entry(fooOne, bar)");
  }

  @Autowired
  @Qualifier("fooImplOne")
  public void setFooOne(Foo foo){
    this.fooOne = foo;
    System.out.println("set fooOne");
  }
  
  @Autowired
  @Qualifier("fooImplTwo")
  public void setFooTwo(Foo foo){
    this.fooTwo = foo;
    System.out.println("set fooTwo");
  }
  
  @Autowired
  public void setBar(Bar bar){
    this.bar = bar;
    System.out.println("set bar");
  }

  public static void main(String[] args) {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:spring/app-sandbox.xml");
    ctx.refresh();

    // specify get bean "gigi" when multiple names of Entry.class exists
    Entry t = ctx.getBean("gigi", Entry.class);
    t.fooOne.sing();
    t.fooTwo.sing();

    ctx.close();
  }
  
  
    
  
}








