/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wordgame;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WordGameTest {
  WordChooser wordChooserMock;
  Player playerMock1, playerMock2;
  WordGame game;

  @Before
  public void setup() {
    wordChooserMock = mock(WordChooser.class);

    playerMock1 = mock(Player.class);
    when(playerMock1.isWinner()).thenReturn(true);
    when(playerMock1.getName()).thenReturn("Jonny");
    when(playerMock1.getPoints()).thenReturn(0);
    when(playerMock1.getWord()).thenReturn("Python");
    when(playerMock1.getAttemptsRemaining()).thenReturn(10);

    playerMock2 = mock(Player.class);
    when(playerMock2.isWinner()).thenReturn(true);
    when(playerMock2.getName()).thenReturn("Jimmy");
    when(playerMock2.getPoints()).thenReturn(0);
    when(playerMock2.getWord()).thenReturn("Python");
    when(playerMock2.getAttemptsRemaining()).thenReturn(10);

    game = new WordGame();
    game.addPlayer("Player 1");
  }

  @Test
  public void checkPlayersAreAddedSuccessfully() {
    assertEquals(Integer.valueOf(1), game.getNumberOfPlayers());
  }

  @Test
  public void testStartGame() {
    game.addPlayer("Jimmy");
    game.addPlayer("Jonny");
    game.addPlayer("Louise");

    game.startGame();
    Integer players = game.getNumberOfPlayers();
    Integer chosen = game.getCurrentPlayerIndex();
    assertTrue(game.getCurrentPlayerIndex() >= 0);
    assertTrue(game.getCurrentPlayerIndex() < game.getNumberOfPlayers());
  }

  @Test
  public void testResetGame() {
    game.startGame();

    game.reset();

    assertEquals(Integer.valueOf(0), game.getNumberOfPlayers());
    assertEquals(null, game.getCurrentPlayer());
    assertEquals(null, game.getWinner());
  }

  @Test
  public void testGetNextPlayer() {
  }

  @Test
  public void testFinishedWithAttemptsRemaining() {
  }

  @Test
  public void testFinishedWithAWinner() {
  }
}
