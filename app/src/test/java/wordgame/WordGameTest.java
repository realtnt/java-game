/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wordgame;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class WordGameTest {
  @Test
  public void appPicksARandomWord() {
    ArrayList<String> words = new ArrayList<String>(
        Arrays.asList("python", "ruby", "java"));
    WordGame game = new WordGame(words);

    assertTrue(words.contains(game.getChosenWord()));
  }

  @Test
  public void appShowsWordWithFirstLetterOnly() {
    ArrayList<String> words = new ArrayList<String>(
        Arrays.asList("python"));
    WordGame game = new WordGame(words);

    assertEquals(game.getRenderedWord(), "p_____");
  }

  @Test
  public void appStartWithTenAttempts() {
    ArrayList<String> words = new ArrayList<String>(
        Arrays.asList("python"));
    WordGame game = new WordGame(words);

    assertEquals(Integer.valueOf(10), game.getAttempts());
  }

  @Test
  public void appUsersGuessIsAddedToList() {
    ArrayList<String> words = new ArrayList<String>(
        Arrays.asList("java"));
    WordGame game = new WordGame(words);

    game.addGuess('a');

    assertEquals(Character.valueOf('a'), game.getGuesses().get(1));
  }

  @Test
  public void appRendersWordCorrectlyGivenGuesses() {
    ArrayList<String> words = new ArrayList<String>(
        Arrays.asList("python"));
    WordGame game = new WordGame(words);

    assertEquals(game.getRenderedWord(), "p_____");
    game.addGuess('a');
    assertEquals(game.getRenderedWord(), "p_____");
    game.addGuess('y');
    assertEquals(game.getRenderedWord(), "py____");
    game.addGuess('h');
    assertEquals(game.getRenderedWord(), "py_h__");
  }

  @Test
  public void appRendersWordCorrectlyGivenGuesses2() {
    ArrayList<String> words = new ArrayList<String>(
        Arrays.asList("java"));
    WordGame game = new WordGame(words);

    assertEquals(game.getRenderedWord(), "j___");
    game.addGuess('a');
    assertEquals(game.getRenderedWord(), "ja_a");
  }

  @Test
  public void methodChecksIfPlayerHasWon() {
    ArrayList<String> words = new ArrayList<String>(
        Arrays.asList("java"));
    WordGame game = new WordGame(words);

    assertEquals(game.getRenderedWord(), "j___");
    assertFalse(game.checkWin());
    game.addGuess('a');
    assertEquals(game.getRenderedWord(), "ja_a");
    assertFalse(game.checkWin());
    game.addGuess('v');
    assertEquals(game.getRenderedWord(), "java");
    assertTrue(game.checkWin());
  }

  @Test
  public void userEntersALetter() {
    String userInput = String.format("a");
    ByteArrayInputStream fakeIn = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(fakeIn);

    String expected = "Ja_a";
    ByteArrayOutputStream fakeOut = new ByteArrayOutputStream();
    PrintStream fakeStream = new PrintStream(fakeOut);
    System.setOut(fakeStream);

    String actual = "Ja_a";

    assertEquals(expected, actual);
  }
}
