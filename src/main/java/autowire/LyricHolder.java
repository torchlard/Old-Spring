package autowire;

import org.springframework.stereotype.Service;

@Service("lyricHolder")
public class LyricHolder {
  private String value="you will beDJ";

  public String toString(){
    return "LyricHolder: {" + value + "}";
  }
}





