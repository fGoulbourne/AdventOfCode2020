import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Ch16 {
  ArrayList<Category> categories = new ArrayList<>();
  ArrayList<Ticket> tickets = new ArrayList<>();
  HashMap<Category, Integer> positions = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("in.txt"));
    ArrayList<Integer> vals = new ArrayList<>();
    ArrayList<Integer> myVals = new ArrayList<>();

    Ch16 ticketCheck = new Ch16();
    int type = 0;
    int sum = 0;
    boolean validVal;

    while (br.ready()) {
      String line = br.readLine();
      if(line.equals("")) {
        type++;
        br.readLine();
      } else if (type == 0) {
        ticketCheck.catHandler(line);
      } else if (type == 1) {
        String[] sep = line.split(",");
        for (String val : sep) {
          myVals.add(Integer.parseInt(val));
        }
      } else if (type == 2) {
        String[] sep = line.split(",");
        vals = new ArrayList<>();

        for (String val : sep) {
          vals.add(Integer.parseInt(val));
        }
        boolean validTick = true;
        for (int j : vals) {
          validVal = false;
          for (Category i : ticketCheck.categories) {
            validVal = validVal || i.contains(j);
          }
          if(!validVal) {
            sum += j;
            validTick = false;
          }
        }
        if(validTick) {
          ticketCheck.tickets.add(new Ticket(vals, ticketCheck.categories));
        }
      }
    }

    System.out.println(sum + "\n");

    ticketCheck.tickets.forEach(Ticket::setValidCats);

    HashSet<Category> totalValidCats = new HashSet<>();
    HashSet<Category> confirmedCats = new HashSet<>();

    while (confirmedCats.size() != 20) {
      for (int i = 0; i < vals.size(); i++) {
        for (Category cat : ticketCheck.categories) {
          totalValidCats.add(cat);
        }
        totalValidCats.removeAll(confirmedCats);

        for (Ticket tick : ticketCheck.tickets) {
          HashSet<Category> localCats = tick.cats.get(i);
          totalValidCats.retainAll(localCats);
        }

        for (Category cat : totalValidCats) {
          ticketCheck.positions.put(cat, i);
        }

        if (totalValidCats.size() == 1) {
          confirmedCats.add((Category) totalValidCats.toArray()[0]);
        } else {

        }
      }
    }

    Set<Category> catSet = ticketCheck.positions.keySet();

    long multi = 1;
    for (Category key : catSet) {
      if (key.name.contains("departure")) {
        multi *= myVals.get(ticketCheck.positions.get(key));
      }
    }
    System.out.println(multi);
  }



  public void catHandler(String line) {
    String[] parts = line.split("[:-]| or ");
    for (int i = 0; i < parts.length; i++) {
      parts[i] = parts[i].trim();
    }
    int[] bounds = new int[4];
    for (int i = 1; i < parts.length; i++) {
      bounds[i-1] = Integer.parseInt(parts[i]);
    }
    categories.add(new Category(parts[0], bounds[0], bounds[1], bounds[2], bounds[3]));

  }
}
