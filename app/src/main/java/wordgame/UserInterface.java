package wordgame;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
  public void showWelcomeMessage() {
    System.out.println("Welcome to Guess the Word!");
  }

  public void showExitMessage() {
    System.out.println("Goodbye!");
  }

  public void registerPlayers(WordGame game) {
    Scanner sc = new Scanner(System.in);
    sc.useDelimiter(System.lineSeparator());
    System.out.printf("How many players? ");
    Integer players = sc.nextInt();
    for (Integer i = 1; i <= players; i++) {
      System.out.printf("Player %d, enter your name: (Enter for default) ", i);
      game.addPlayer(sc.next());
    }
  }

  public void getUserGuess(Player player) {
    ArrayList<Character> wordArray = Helper.convertStringToArrayList(player.getWord());

    if (player.getAttemptsRemaining() == 0)
      return;

    Scanner sc = new Scanner(System.in);
    Character letter;
    sc.useDelimiter(System.lineSeparator());

    while (true) {
      System.out.printf("Pick a letter: ");
      letter = sc.next().toCharArray()[0];
      if (!player.addGuess(letter)) {
        System.out.println("You have already picked that letter.");
      } else {
        break;
      }
    }

    if (wordArray.contains(letter)) {
      System.out.println("Well done!");
      System.out.printf("Your word is now: ");
      renderWord(player);
    } else {
      System.out.println("Wrong choice!");
    }
  }

  public void showUserGuesses(Player player) {
    StringBuilder sb = new StringBuilder();
    ArrayList<Character> guesses = player.getGuesses();

    sb.append("Your guesses so far: ");
    for (Character guess : guesses.subList(1, guesses.size())) {
      sb.append(String.format("%s ", guess));
    }
    System.out.println(sb.toString());
  }

  public void renderWord(Player player) {
    Masker masker = new Masker();
    System.out.println(masker.getMaskedWord(player.getWord(), player.getGuesses()));
  }

  public void promptPlayer(Player player) {
    System.out.printf("%s, it is your turn to play.\n", player.getName().toUpperCase());
  }

  public void showAttemptsRemaining(Player player) {
    if (player.getAttemptsRemaining() == 0) {
      System.out.println("You have no attempts remaining. You lose!");
    } else {
      System.out.printf("You have %d attempts remaining.\n", player.getAttemptsRemaining());
    }
  }

  public void printDivider() {
    System.out.println("\n*************************************\n");
  }

  public void showWinner(Player winner) {
    System.out.printf("Well done %s! You win!\n", winner.getName());
  }
}
