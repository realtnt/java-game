package wordgame;

import java.util.ArrayList;

public class Helper {
  static ArrayList<Character> convertStringToArrayList(String word) {
    ArrayList<Character> chars = new ArrayList<Character>();
    for (char c : word.toCharArray()) {
      chars.add(c);
    }
    return chars;
  }
}
