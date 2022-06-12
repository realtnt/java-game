package wordgame;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class WordChooserTest {
  private WordChooser chooser;

  @Before
  public void setup() {
    chooser = new WordChooser();
  }

  @Test
  public void checkWordIsInDictionary() {
    assertTrue(
        Arrays.asList(chooser.getDictionary()).contains(chooser.getRandomWordFromDictionary()));
  }
}
