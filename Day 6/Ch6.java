import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Ch6 {

  public static void main(String[] args) throws Exception {
    part1();
    part2();
  }

  public static void part1() throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("questions.txt"));
    HashSet<Character> questions = new HashSet<>();
    String line;
    int qSum = 0;

    while (br.ready()) {
      line = br.readLine();
      if(line != null && line.length() != 0) {
        for (int i = 0; i < line.length(); i++) {
          questions.add(line.charAt(i));
        }
      } else {
        qSum += questions.size();
        questions = new HashSet<>();
      }

    }
    qSum += questions.size();
    System.out.println(qSum);
  }

  public static void part2() throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("questions.txt"));
    HashSet<Character> questionsOne = new HashSet<>();
    HashSet<Character> questionsAll = new HashSet<>();
    String line;
    char ch;
    int qSum = 0;
    for(int i = 0; i < 26; i++) {
      questionsAll.add((char)('a' + i));
    }

    while(br.ready()) {

      line = br.readLine();
      if(line != null && line.length() != 0){
        for (int i = 0; i < line.length(); i++) {
          questionsOne.add(line.charAt(i));
        }
        questionsAll.retainAll(questionsOne);
        questionsOne = new HashSet<>();
      } else {
        qSum += questionsAll.size();
        for(int i = 0; i < 26; i++) {
          questionsAll.add((char)('a' + i));
        }
      }
    }
    qSum += questionsAll.size();

    System.out.println(qSum);
  }
}
