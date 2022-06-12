package wordgame;

import java.util.ArrayList;

public class Masker {
  private Character maskingCharacter = '_';

  public String getMaskedWord(String word, ArrayList<Character> guesses) {
    char[] wordArray = word.toCharArray();
    StringBuilder sb = new StringBuilder();

    for (Character letter : wordArray) {
      if (guesses.contains(Character.toLowerCase(letter))) {
        sb.append(letter);
      } else {
        sb.append(maskingCharacter);
      }
    }
    return sb.toString();
  }
}
