package Simple;

public class HelloWorldMessageProvider implements MessageProvider {
  public HelloWorldMessageProvider(){
    System.out.println("start hello world msg provider");
  }

  public String getMessage(){
    return "hello world";
  }
}







