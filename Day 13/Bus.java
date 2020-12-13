import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bus {
  public int size;
  public int offset;
  public HashMap<Integer, Integer> factors;

  public Bus(int size, int offset) {
    this.size = size;
    this.offset = offset;

    factors = new HashMap<>();
    int temp = size;
    int prime = 2;

    while (temp > 1) {
      if (temp % prime == 0) {
        if (factors.putIfAbsent(prime, 1) != null) {
          factors.put(prime, factors.get(prime) + 1);
        }
        temp /= prime;
        prime = 2;
      } else {
        prime++;
      }
    }
  }
}
