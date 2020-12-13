import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Ch13 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in1.txt"));
    int bus;
    String[] line;
    ArrayList<Integer> times = new ArrayList<>();
    int min = 999;
    int busNum = 0;



    bus = Integer.parseInt(br.readLine());
    line = br.readLine().split(",");
    for (String i : line) {
      try {
        times.add(Integer.parseInt(i));
      } catch (Exception e) {
        times.add(-1);
      }
    }

    for (Integer i : times) {
      if (i != -1 && i - (bus % i) < min) {
        busNum = i;
        min = i - (bus % i);
      }
    }

    System.out.println(busNum * min + "\n");

    ArrayList<Bus> values = new ArrayList<>();
    for (int i = 0; i < times.size(); i++) {
      if (times.get(i) != -1) {
        values.add(new Bus(times.get(i), i));
      }
    }
    System.out.println(lowComDen(values));
    long multi = 1;
    long firstVal = 1;
    ArrayList<Bus> concBus = new ArrayList<>();
    for (Bus i : values) {
      concBus.add(i);
      for (long j = firstVal; true; j += multi) {
        if ((j + i.offset) % i.size == 0) {
          firstVal = j;
          break;
        }
      }
      multi = lowComDen(concBus);
    }

    System.out.println(firstVal);
  }

  public static long lowComDen(ArrayList<Bus> busList) {
    HashMap<Integer, Integer> primes = new HashMap<>();
    Set<Integer> set;
    for (Bus i : busList) {
      set = i.factors.keySet();

      for (Integer j : set) {
        if (primes.putIfAbsent(j, i.factors.get(j)) != null) {
          primes.put(j, Math.max(primes.get(j), i.factors.get(j)));
        }

      }
    }
    long multi = 1;
    set = primes.keySet();
    for (Integer j : set) {
      multi *= (Math.pow(j, primes.get(j)));
    }
    return multi;
  }
}
