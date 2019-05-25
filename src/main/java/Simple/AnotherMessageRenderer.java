package Simple;

import org.springframework.beans.factory.annotation.Autowired;

public class AnotherMessageRenderer implements MessageRenderer {

  private MessageProvider messageProvider;
  private NumProvider numProvider;


  public AnotherMessageRenderer(){
    System.out.println("--> start another msg renderer");
  }

  public void render(){
    if(messageProvider == null){
      throw new RuntimeException(
        "must set property msg of class: " + messageProvider.getClass().getName()
      );
    }
    System.out.println(messageProvider.getMessage() + " "+ (numProvider.getNum()+5));
  }

  public void setMessageProvider(MessageProvider provider){
    System.out.println("set msg provider in AnotherRenderer");
    this.messageProvider = provider;
  }

  public MessageProvider getMessageProvider(){
    return messageProvider;
  }

  // need this method to be invoke by reflection by spring to inject provider
  public void setNumProvider(NumProvider provider){
    this.numProvider = provider;
  }
  
}






