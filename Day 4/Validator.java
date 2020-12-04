import java.io.BufferedReader;
import java.util.ArrayList;


public class Validator {

  public Validator() {}


  public boolean isValid(ArrayList<String> lines) {
    int fieldCount = 0;
    for(String line : lines) {
      String[] terms = line.split(":|\s");

      for (int i = 0; i < terms.length; i++) {

        switch (terms[i]) {
          case "ecl":
            if (eclCheck(terms[i+1])) {
              fieldCount++;
            }
            break;
          case "pid":
            if (pidCheck(terms[i+1])){
              fieldCount++;
            }
            break;
          case "eyr":
            if (eyrCheck(terms[i+1])){
              fieldCount++;
            }
            break;
          case "hcl":
            if (hclCheck(terms[i+1])){
              fieldCount++;
            }
            break;
          case "byr":
            if (byrCheck(terms[i+1])){
              fieldCount++;
            }
            break;
          case "iyr":
            if (iyrCheck(terms[i+1])){
              fieldCount++;
            }
            break;
          case "hgt":
            if (hgtCheck(terms[i+1])){
              fieldCount++;
            }
            break;
        }
      }
    }
    return fieldCount >= 7;
  }

  private boolean byrCheck(String term) {
    if (term.length() == 4) {
      int year = Integer.parseInt(term);
      return year >= 1920 && year <= 2002;
    }
    return false;
  }

  private boolean iyrCheck(String term) {
    if (term.length() == 4) {
      int year = Integer.parseInt(term);
      return year >= 2010 && year <= 2020;
    }
    return false;
  }

  private boolean eyrCheck(String term) {
    if (term.length() == 4) {
      int year = Integer.parseInt(term);
      return year >= 2020 && year <= 2030;
    }
    return false;
  }

  private boolean hgtCheck(String term) {
    int len = term.length();
    int val;

    if (term.matches("^[1-9][0-9]*cm$")) {
      val = Integer.parseInt(term.substring(0, len-2));
      return val >= 150 && val <= 193;
    } else if (term.matches("^[1-9][0-9]*in")) {
      val = Integer.parseInt(term.substring(0, len-2));
      return val >= 59 && val <= 76;
    }
    return false;
  }

  private boolean hclCheck(String term) {
    return term.matches("^#([0-9a-f]){6}$");
  }

  private boolean eclCheck(String term) {
    return term.matches("^(amb|blu|brn|gry|grn|hzl|oth)$");
  }

  private boolean pidCheck(String term) {
    return term.matches("^[0-9]{9}$");
  }
}
