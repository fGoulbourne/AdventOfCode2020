import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ch7 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("rules.txt"));

    String[] bags;
    String bag;
    ArrayList<String> bagFormat = new ArrayList<>();
    int totalBags = 0;
    while (br.ready()) {
      bags = br.readLine().split("\sbag|contain");

      for (int i = 0; i < bags.length - 1; i++) {
        bag = bags[i];

        if (i != 1) {
          bag = bag.replaceAll("^s,\s", "");
          bag = bag.replaceAll("[,\s]", "");
          bagFormat.add(bag);
        }

      }
      Bag bagTemp = new Bag(bagFormat, "shinygold");
      bagFormat.clear();
    }
    part1();
    part2();
  }



  public static void part1() throws Exception {
    int totalBags = 0;
    for(Bag i : Bag.sorter.values()) {
      if (i.hasBag()) {
        totalBags++;
      }
    }
    System.out.println(totalBags - 1);
  }

  public static void part2() throws Exception {
    int totalBags = 0;

    System.out.println(Bag.sorter.get("shinygold").contains());
  }
}
