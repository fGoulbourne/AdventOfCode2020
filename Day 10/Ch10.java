import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ch10 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    ArrayList<Integer> adapters = new ArrayList<>();
    int[] differences = {0, 0, 0, 0};
    int diff;

    while(br.ready()) {
      adapters.add(Integer.parseInt(br.readLine()));
    }
    adapters.add(0);
    Collections.sort(adapters);
    adapters.add(adapters.get(adapters.size() - 1) + 3);

    for (int i = 1; i < adapters.size(); i++) {
      if ((diff = adapters.get(i) - adapters.get(i-1)) <= 3) {
        differences[diff]++;
      } else {
        break;
      }
    }
    System.out.println(differences[1] * differences[3]);

    // Part 2
    ArrayList<ArrayList<Integer>> subCombos = new ArrayList<>();
    ArrayList<Integer> subCombo = new ArrayList<>();
    subCombo.add(0);

    for (int i = 1; i < adapters.size(); i++) {
      if ((diff = adapters.get(i) - adapters.get(i-1)) < 3) {
        subCombo.add(adapters.get(i));
      } else if ((diff = adapters.get(i) - adapters.get(i-1)) == 3) {
        subCombos.add(subCombo);
        subCombo = new ArrayList<>();
        subCombo.add(adapters.get(i));
      }

    }
    long multi = 1;
    for (ArrayList<Integer> i : subCombos) {
      switch (i.size()) {
        case 1, 2 -> multi *= 1;
        case 3 -> multi *= 2;
        case 4 -> multi *= 4;
        case 5 -> multi *= 7;
      }

    }
    System.out.println(multi);
  }




}
