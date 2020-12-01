import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ch1 {

  public static void main(String[] args) throws Exception {
    ArrayList<Integer> expenses = new ArrayList<>();

    Class cls = Class.forName("Ch1");
    ClassLoader clsLd = cls.getClassLoader();

    BufferedReader br = new BufferedReader(new InputStreamReader(clsLd.getResourceAsStream("expenses.txt")));

    String val = br.readLine();

    while (val != null) {
      expenses.add(Integer.parseInt(val));
      val = br.readLine();
    }

    Collections.sort(expenses);

    ValueFinder get2020 = new ValueFinder(expenses, 2020);
    get2020.findVal_3();

  }




}
