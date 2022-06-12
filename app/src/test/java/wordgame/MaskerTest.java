package wordgame;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class MaskerTest {
  @Test
  public void testGetsMaskedWord() {
    Masker masker = new Masker();
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('d');
    guessedLetters.add('e');
    guessedLetters.add('v');

    assertEquals("DEVE___E_", masker.getMaskedWord("DEVELOPER", guessedLetters));
  }
}
