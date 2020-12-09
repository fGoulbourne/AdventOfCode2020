import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Ch9 {
  public static final int BUFFER = 25;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    ArrayList<Long> numbers = new ArrayList<>();
    ArrayList<Long> fullNumbers = new ArrayList<>();
    HashSet<Long> hashNum = new HashSet<>();
    boolean contained = false;

    int index = 0;
    long num;
    long val = 0;

    for (int i = 0; i < BUFFER; i++) {
      long parseLong = Long.parseLong(br.readLine());
      numbers.add(parseLong);
      fullNumbers.add(parseLong);
    }

    while (br.ready()) {
      num = Long.parseLong(br.readLine());
      fullNumbers.add(num);
      hashNum.clear();
      for (int i = 0; i < BUFFER; i++) {
        hashNum.add(numbers.get(i));
      }

      for (Long i : numbers) {
        hashNum.remove(i);
        if (hashNum.contains(num - i)) {
          contained = true;
          break;
        } else {

        }
        hashNum.add(i);
      }

      if (!contained) {
        System.out.println(num + "\n");
        val = num;
      }
      numbers.set(index % BUFFER, num);
      index ++;
      contained = false;
    }


    // Part 2
    ArrayList<Long> sequence = new ArrayList<>();
    Long sum;
    for (int i = 0; i < fullNumbers.size(); i++) {
      sum = 0L;

      for(Long j : sequence) {
        sum += j;
      }

      if(sum == val && sequence.size() != 1) {
        break;
      } else if (sum < val) {
        sequence.add(fullNumbers.get(i));
      } else {
        sequence.remove(0);
        i--;
      }
    }
    Collections.sort(sequence);
    Long min = sequence.get(0);
    Long max = sequence.get(sequence.size() - 1);
    System.out.println(min + max);

  }
}
