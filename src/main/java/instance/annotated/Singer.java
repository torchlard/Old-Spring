package instance.annotated;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component("nonSingleton")
// @Scope("singleton")
// @Scope("prototype")
public class Singer {

  private String name = "unknown";
  private int age;

  public void setName(String name){
    this.name = name;
  }
  public void setAge(int age){
    this.age = age;
  }

  // public Singer(@Value("John Mayer") String name){
  //   this.name = name;
  // }
  // public Singer(String name, int age){
  //   this.name = name;
  //   this.age = age;
  // }

  public String toString(){
    return "["+name+", "+age+"]";
  }
  
}








