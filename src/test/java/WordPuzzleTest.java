import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class WordPuzzleTest extends FluentTest {

  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void puzzle_changeLetter_a(){
    WordPuzzle wordpuzzle = new WordPuzzle();
    String expValue = "b-n-n-";
    assertEquals(expValue, wordpuzzle.puzzle("banana"));
  }

  @Test
  public void puzzle_changeLetter_aeiou(){
    WordPuzzle wordpuzzle = new WordPuzzle();
    String expValue = "B-l--v- y-- c-n -nd y--'r- h-lfw-y th-r-. Th--d-r- R--s-v-lt";
    assertEquals(expValue, wordpuzzle.puzzle("Believe you can and you're halfway there. Theodore Roosevelt"));
  }

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Word Puzzle");
  }

  @Test
  public void result_displayCorrectOutput() {
    goTo("http://localhost:4567/");
    fill("#phrase").with("queen");
    submit(".btn");
    assertThat(pageSource()).contains("q---n");
  }

}
