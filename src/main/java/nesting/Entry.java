package nesting;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Entry {

  public static void main(String[] args) {
    GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
    parent.load("classpath:spring/parent-context.xml");
    parent.refresh();

    GenericXmlApplicationContext child = new GenericXmlApplicationContext();
    child.load("classpath:spring/child-context.xml");
    child.setParent(parent);
    child.refresh();

    Song song1 = child.getBean("song1", Song.class);
    Song song2 = child.getBean("song2", Song.class);
    Song song3 = child.getBean("song3", Song.class);

    // use parent's title
    System.out.println("song1: "+song1.getTitle());
    // override by child's title
    System.out.println("song2: "+song2.getTitle());
    // 
    System.out.println("song3: "+song3.getTitle());

    child.close();
    parent.close();
    
        
  }
  
  
}





