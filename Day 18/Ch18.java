import java.io.BufferedReader;
import java.io.FileReader;

public class Ch18 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    long sum = 0;
    while (br.ready()) {
      Calculator calc = new Calculator(br.readLine());
      sum += calc.calculate(1);

    }

    System.out.println(sum + "\n");
    br = new BufferedReader(new FileReader("in.txt"));
    sum = 0;
    while (br.ready()) {
      Calculator calc = new Calculator(br.readLine());
      sum += calc.calculate(2);
    }

    System.out.println(sum);
  }
}
