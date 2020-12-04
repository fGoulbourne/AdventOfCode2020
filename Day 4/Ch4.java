import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ch4 {


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("PP.txt"));
    ArrayList<String> lines = new ArrayList<>();
    Validator ppValid = new Validator();
    int validCount = 0;

    String line;
    while (br.ready()) {
      line = br.readLine();
      if (line.length() != 0 && line != null) {
        lines.add(line);
      } else {
        if (ppValid.isValid(lines)) {
          validCount++;
        }
        lines = new ArrayList<>();
      }
    }
    if (ppValid.isValid(lines)) {
      validCount++;
    }

    System.out.println(validCount);

  }


}
