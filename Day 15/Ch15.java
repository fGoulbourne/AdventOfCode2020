import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Ch15 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));

    HashMap<Integer, Integer> numbers = new HashMap<>();
    int turn = 1;
    Integer current = null;
    Integer turnNum;
    Integer lastSeen = null;

    String[] vals = br.readLine().split(",");

    for (String val : vals) {
      int intVal = Integer.parseInt(val);
      current = numbers.get(intVal);
      numbers.put(intVal, turn);
      turn++;
    }

    while (turn <= 30000000) {
      if (current != null) {
        current = turn - lastSeen - 1;
        lastSeen = (numbers.get(current) == null) ? turn : numbers.get(current);
        numbers.put(current, turn);

      } else {
        current = 0;
        lastSeen = (numbers.get(current) == null) ? turn : numbers.get(current);
        numbers.put(0, turn);

      }
      if (turn == 2020) {
        System.out.println(current + "\n");
      }
      turn++;

    }

    System.out.println(current);



  }
}
