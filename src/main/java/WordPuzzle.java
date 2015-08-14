import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class WordPuzzle {
  public static void main(String[] args){
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template","templates/result.vtl");

      String phrase = request.queryParams("phrase");
      String result = puzzle(phrase);
      model.put("result", result);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String puzzle(String phrase) {

    // convert phrase into char Array
    char[] phraseChar = phrase.toCharArray();

    // replace vowels with dash symbol
    for (Integer index = 0; index < phrase.length(); index++) {
      if (phraseChar[index] == 'a' || phraseChar[index] == 'e' ||
          phraseChar[index] == 'i' || phraseChar[index] == 'o' ||
          phraseChar[index] == 'u'){

        phraseChar[index] = '-';

      } else if (phraseChar[index] == 'A' || phraseChar[index] == 'E' ||
          phraseChar[index] == 'I' || phraseChar[index] == 'O' ||
          phraseChar[index] == 'U'){

        phraseChar[index] = '-';
      }
    }

    // return string with dashes instead of vowels
    String output = new String(phraseChar);
    return output;
  }

}
