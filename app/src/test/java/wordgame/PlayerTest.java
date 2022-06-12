package wordgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

  private WordChooser wordChooserMock;
  private Player player;

  @Before
  public void setup() {
    player = new Player(10, "Python");
  }

  @Test
  public void defaultNameWhatEmptyNameIsPassed() {
    player.setName("");

    assertEquals("Player 1", player.getName());
  }

  @Test
  public void checkNameChanges() {
    player.setName("Jimmy");

    assertEquals("Jimmy", player.getName());
  }

  @Test
  public void settingWordForPlayerWorks() {
    assertEquals("Python", player.getWord());
  }

  @Test
  public void guessesAreAddedToTheList() {
    assertEquals(Character.valueOf('p'), player.getGuesses().get(0));
    player.addGuess('a');
    assertEquals(Character.valueOf('a'), player.getGuesses().get(1));
    player.addGuess('y');
    assertEquals(Character.valueOf('y'), player.getGuesses().get(2));
    player.addGuess('h');
    assertEquals(Character.valueOf('h'), player.getGuesses().get(3));
  }

  @Test
  public void methodChecksIfPlayerHasWon() {
    assertFalse(player.isWinner());
    player.addGuess('y');
    assertFalse(player.isWinner());
    player.addGuess('t');
    player.addGuess('h');
    player.addGuess('o');
    player.addGuess('n');
    assertTrue(player.isWinner());
  }
}
