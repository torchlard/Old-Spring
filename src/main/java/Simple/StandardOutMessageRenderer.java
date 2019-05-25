package Simple;

public class StandardOutMessageRenderer implements MessageRenderer {

  private MessageProvider messageProvider;
  private NumProvider numProvider;

  public StandardOutMessageRenderer(){
    System.out.println("--> start std msg renderer");
  }

  public void render(){
    if(messageProvider == null){
      throw new RuntimeException(
        "must set property msg of class: " + messageProvider.getClass().getName()
      );
    }
    System.out.println(messageProvider.getMessage() + " "+ numProvider.getNum());
  }

  public void setMessageProvider(MessageProvider provider){
    System.out.println("set msg provider");
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






