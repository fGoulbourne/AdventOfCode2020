import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ch2 {

  public static void main(String[] args) throws Exception{
    Class cls = Class.forName("Ch2");
    ClassLoader clsLd = cls.getClassLoader();

    BufferedReader br = new BufferedReader(new InputStreamReader(clsLd.getResourceAsStream("passwords.txt")));

    ArrayList<String> passwords = new ArrayList<>();
    String line = br.readLine();
    while(line != null) {
      passwords.add(line);
      line = br.readLine();
    }
    PassAnalyser analyse = new PassAnalyser(passwords);
    System.out.println(analyse.validPassCount(2));
  }
}
