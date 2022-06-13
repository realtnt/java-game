package wordgame;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class UserInterfaceTest {
  private UserInterface ui;
  private ByteArrayOutputStream fakeOutStream;
  private PrintStream fakePrintStream;
  private Player playerMock;

  @Before
  public void setup() {
    playerMock = mock(Player.class);
    ui = new UserInterface();
    fakeOutStream = new ByteArrayOutputStream();
    fakePrintStream = new PrintStream(fakeOutStream);
    System.setOut(fakePrintStream);
  }

  @Test
  public void testShowWelcomeMessage() {
    String expected = "Welcome to Guess the Word!";

    ui.showWelcomeMessage();

    String[] lines = fakeOutStream.toString().split(System.lineSeparator());
    String actual = lines[lines.length - 1];

    assertEquals(expected, actual);
  }

  @Test
  public void testShowExitMessage() {
    String expected = "Goodbye!";

    ui.showExitMessage();

    String[] lines = fakeOutStream.toString().split(System.lineSeparator());
    String actual = lines[lines.length - 1];

    assertEquals(expected, actual);
  }

  @Test
  public void testRegisterPlayers() {
    // WordGame game = new WordGame();
    // String userInput = String.format("2");
    // ByteArrayInputStream fakeIn = new ByteArrayInputStream(userInput.getBytes());
    // System.setIn(fakeIn);

    // String expected = "How many players? ";
    // ui.registerPlayers(game);

    // String[] lines = fakeOutStream.toString().split(System.lineSeparator());
    // String actual = lines[lines.length - 1];

    // assertEquals(expected, actual);

    // assertEquals(Integer.valueOf(2), players);
  }

  @Test
  public void testGetUserGuess() {
    // String expected = "Pick a letter: ";

    // String userInput = String.format("y");
    // ByteArrayInputStream fakeIn = new ByteArrayInputStream(userInput.getBytes());
    // System.setIn(fakeIn);

    // when(playerMock.getName()).thenReturn("Player 1");
    // when(playerMock.getWord()).thenReturn("Python");
    // when(playerMock.getAttemptsRemaining()).thenReturn(10);
    // when(playerMock.addGuess(any())).thenReturn(true);
    // ui.getUserGuess(playerMock);
    // String[] lines = fakeOutStream.toString().split(System.lineSeparator());
    // String actual = lines[lines.length - 1];

    // assertEquals(expected, actual);
  }

  @Test
  public void testRenderWord() {
    ArrayList<Character> guesses = new ArrayList<Character>(
        Arrays.asList('p', 'y'));
    Masker masker = mock(Masker.class);

    when(masker.getMaskedWord("Python", guesses)).thenReturn("Py____");
    assertEquals("Py____", masker.getMaskedWord("Python", guesses));
  }

  @Test
  public void testShowUserGuesses() {
    ArrayList<Character> guesses = new ArrayList<Character>(
        Arrays.asList('p', 'y'));

    String expected = "Your guesses so far: y ";

    when(playerMock.getGuesses()).thenReturn(guesses);
    ui.showUserGuesses(playerMock);
    String[] lines = fakeOutStream.toString().split(System.lineSeparator());
    String actual = lines[lines.length - 1];
    assertEquals(expected, actual);
  }

  @Test
  public void testshowAttemptsRemaining() {
    String expected = "You have 10 attempts remaining.";

    when(playerMock.getAttemptsRemaining()).thenReturn(10);
    ui.showAttemptsRemaining(playerMock);
    String[] lines = fakeOutStream.toString().split(System.lineSeparator());
    String actual = lines[lines.length - 1];

    assertEquals(expected, actual);
  }

  @Test
  public void testshowAttemptsRemainingWhenZero() {
    String expected = "You have no attempts remaining. You lose!";

    when(playerMock.getAttemptsRemaining()).thenReturn(0);
    ui.showAttemptsRemaining(playerMock);
    String[] lines = fakeOutStream.toString().split(System.lineSeparator());
    String actual = lines[lines.length - 1];

    assertEquals(expected, actual);
  }
}
