import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bag {

  private HashSet<String[]> type;
  private String bagType;
  private boolean containsBag;
  private String name;
  private Integer size;

  public static HashMap<String, Bag> sorter = new HashMap<>();

  public Bag(ArrayList<String> bagNames, String bagType) {
    this.name = bagNames.get(0);
    type = new HashSet<>();



    sorter.put(name, this);

    if(name.equals(bagType)) {
      this.containsBag = true;
    }

    for(int i = 1; i < bagNames.size(); i++) {
      if (!bagNames.get(i).equals("noother")) {
        String bagStats = bagNames.get(i);
        String[] bagCount = new String[2];
        bagCount[0] = bagStats.substring(1);
        bagCount[1] = bagStats.substring(0, 1);

        type.add(bagCount);
      } else {
        this.size = 0;
      }
    }

    this.bagType = bagType;
  }

  public boolean hasBag() {
    if (containsBag) {
      return true;
    }

    Bag sBag;
    for (String[] i : type) {
       sBag = sorter.get(i[0]);
       if(sBag.hasBag()) {
         containsBag = true;
         return true;
       }
    }
    return false;
  }

  public String getName() {
    return name;
  }

  public int contains() {
    int bagQuant;
    if (size != null) {
      return size;
    } else {
      size = 0;
      for (String[] i : type) {
        bagQuant = Integer.parseInt(i[1]);
        size += (bagQuant * (1 + sorter.get(i[0]).contains()));

      }
      return size;
    }
  }


}
