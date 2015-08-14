import java.io.Console;
import java.util.Arrays;
import java.util.List;
import static spark.Spark.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class WordPuzzle {
  public static void main(String[] args){ }

  public static String puzzle(String phrase) {

    char[] phraseChar = phrase.toCharArray();
    //Character[] phraseCharacter = ArrayUtils.toObject(phraseChar);

    for (Integer index = 0; index < phrase.length(); index++) {
      if (phraseChar[index] == 'a'){
        phraseChar[index] = '-';
      }

    }
    String output = new String(phraseChar);
    return output;


  }

}
