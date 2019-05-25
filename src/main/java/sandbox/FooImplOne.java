package sandbox;

import org.springframework.stereotype.Component;

@Component
public class FooImplOne implements Foo{
  public void sing(){
    System.out.println("I am foo 1");
  }
}

