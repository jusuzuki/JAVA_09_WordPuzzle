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
      model.put("phrase", phrase);
      String result = puzzle(phrase);
      model.put("result", result);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

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
