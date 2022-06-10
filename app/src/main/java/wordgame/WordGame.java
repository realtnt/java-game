/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wordgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
  private Scanner scanner = new Scanner(System.in);

  ArrayList<String> words = new ArrayList<String>();
  ArrayList<Character> guesses = new ArrayList<Character>();
  String chosenWord = "";
  String renderedWord = "";
  static Integer attempts = 10;

  public WordGame(ArrayList<String> wordList) {
    words = wordList;
    chooseWord();
  }

  public void addGuess(Character guess) {
    guesses.add(Character.toLowerCase(guess));
    buildWord();
  }

  public Boolean checkWin() {
    return !renderedWord.contains("_");
  }

  public void getUserGuess() {
    addGuess(scanner.nextLine().toCharArray()[0]);
  }

  public void printWord() {
    System.out.println(renderedWord);
  }

  // GETTERS
  public String getChosenWord() {
    return chosenWord;
  }

  public Integer getAttempts() {
    return attempts;
  }

  public ArrayList<Character> getGuesses() {
    return guesses;
  }

  public String getRenderedWord() {
    return renderedWord;
  }

  // PRIVATE METHODS
  private void chooseWord() {
    Random random = new Random();
    Integer randomIndex = random.nextInt(words.size());
    chosenWord = words.get(randomIndex).toLowerCase();
    guesses.add(chosenWord.charAt(0));
    buildWord();
  }

  private void buildWord() {
    char[] chosenWordArray = chosenWord.toCharArray();
    StringBuilder sb = new StringBuilder();

    for (Character ch : chosenWordArray) {
      if (guesses.contains(ch)) {
        sb.append(ch);
      } else {
        sb.append('_');
      }
    }
    renderedWord = sb.toString();
  }

  public static void main(String[] args) {
    ArrayList<String> words = new ArrayList<String>(
        Arrays.asList("python", "ruby", "java", "actionscript", "ada", "typescript"));
    WordGame game = new WordGame(words);

    game.printWord();
    for (Integer i = 1; i <= attempts; i++) {
      System.out.println("Give me a letter: ");
      game.getUserGuess();
      game.printWord();
      if (game.checkWin()) {
        System.out.println("You Won!");
        break;
      } else if (!game.checkWin() && i == attempts) {
        System.out.println("You Lost!");
      }
    }
  }
}
