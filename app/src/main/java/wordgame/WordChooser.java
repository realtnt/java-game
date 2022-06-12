package wordgame;

import java.util.Random;

public class WordChooser {
  private final String[] DICTIONARY = {
      "Python",
      "Ruby",
      "Java",
      "JavaScript",
      "Swift",
      "Golang",
      "Dart",
      "Scala",
      "Kotlin",
      "Assembly",
      "Clojure",
      "Fortran",
      "Matllab"
  };

  public String getRandomWordFromDictionary() {
    Random random = new Random();
    Integer randomIndex = random.nextInt(DICTIONARY.length);
    return DICTIONARY[randomIndex];
  }

  // GETTERS

  public String[] getDictionary() {
    return DICTIONARY;
  }
}
