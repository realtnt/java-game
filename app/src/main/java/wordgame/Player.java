package wordgame;

import java.util.ArrayList;

public class Player {
  static Integer players = 0;

  private ArrayList<Character> guesses = new ArrayList<Character>();
  private String name;
  private Integer attemptsRemaining;
  private Integer points = 0;
  private String word;
  private Integer playerNumber;

  public Player(Integer attempts, String word) {
    players++;
    playerNumber = players;
    attemptsRemaining = attempts;
    this.word = word;
    guesses.add(Character.toLowerCase(word.charAt(0)));
  }

  public Boolean addGuess(Character guess) {
    ArrayList<Character> wordArray = Helper.convertStringToArrayList(word);
    if (guesses.contains(Character.toLowerCase(guess))) {
      return false;
    }
    guesses.add(Character.toLowerCase(guess));
    if (!wordArray.contains(guess)) {
      attemptsRemaining--;
    }
    return true;
  }

  public Boolean isWinner() {
    char[] wordArray = word.toCharArray();

    for (Character letter : wordArray) {
      if (!guesses.contains(Character.toLowerCase(letter))) {
        return false;
      }
    }
    return true;
  }

  // GETTERS
  // *******
  public Integer getPlayerNumber() {
    return playerNumber;
  }

  public ArrayList<Character> getGuesses() {
    return guesses;
  }

  public Integer getPoints() {
    return points;
  }

  public String getName() {
    return name;
  }

  public Integer getAttemptsRemaining() {
    return attemptsRemaining;
  }

  public String getWord() {
    return word;
  }

  // SETTERS
  // *******
  public void setAttemptsRemaining(Integer attemptsRemaining) {
    this.attemptsRemaining = attemptsRemaining;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public void setName(String name) {
    var sb = new StringBuilder();
    if (name.isEmpty()) {
      sb.append(String.format("Player %d", playerNumber));
      name = sb.toString();
    }
    this.name = name;
  }

  public void setWord(String word) {
    this.word = word;
  }
}
