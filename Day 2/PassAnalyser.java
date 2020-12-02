import java.util.ArrayList;

public class PassAnalyser {
  private ArrayList<String> pws;

  public PassAnalyser(ArrayList<String> pws) {
    this.pws = pws;
  }

  private ArrayList<String[]> splitString() {
    ArrayList<String[]> out = new ArrayList<>();

    for(String i : pws) {
      out.add(i.split(":|-|\s"));
    }
    return out;
  }

  public boolean passwordCheck1(String[] pwSplit) {
    int min = Integer.parseInt(pwSplit[0]);
    int max = Integer.parseInt(pwSplit[1]);
    char symbol = pwSplit[2].charAt(0);

    ArrayList<Character> charList = new ArrayList<>();
    for(int i = 0; i < pwSplit[4].length(); i++) {
      charList.add(pwSplit[4].charAt(i));
    }

    int charCount = 0;
    for(Character i : charList) {
      if(i == symbol) {
        charCount++;
      }
    }

    if(charCount >= min && charCount <= max) {
      return true;
    } else {
      return false;
    }

  }

  public int validPassCount(int type) {
    int out = 0;
    for(String[] i : splitString()) {
      if(type == 1) {
        if (passwordCheck1(i) == true) {
          out++;
        }
      } else if(type == 2) {
        if (passwordCheck2(i) == true) {
          out++;
        }
      }
    }
    return out;
  }

  public boolean passwordCheck2(String[] pwSplit) {
    int idx1 = Integer.parseInt(pwSplit[0]) - 1;
    int idx2 = Integer.parseInt(pwSplit[1]) - 1;
    char symbol = pwSplit[2].charAt(0);

    ArrayList<Character> charList = new ArrayList<>();
    for(int i = 0; i < pwSplit[4].length(); i++) {
      charList.add(pwSplit[4].charAt(i));
    }
    int validIndex = 0;
    if(charList.get(idx1) == symbol) {
      validIndex++;
    }
    if(charList.get(idx2) == symbol) {
      validIndex++;
    }
    return (validIndex == 1) ? true : false;
  }
}
